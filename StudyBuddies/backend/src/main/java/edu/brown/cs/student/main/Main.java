package edu.brown.cs.student.main;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import edu.brown.cs.student.main.Call.CallCommands;
import edu.brown.cs.student.main.Connection.DatabaseConnect;
import edu.brown.cs.student.main.Creation.HandleCourses;
import edu.brown.cs.student.main.Creation.HandleStudent;
import edu.brown.cs.student.main.Objects.Course;
import edu.brown.cs.student.main.Objects.MatchStudent;
import edu.brown.cs.student.main.Objects.Student;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.bson.Document;
import spark.ExceptionHandler;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import org.json.JSONObject;

public final class Main {
  private static final int DEFAULT_PORT = 5678;
  private static final Gson GSON = new Gson();
  private static final int TRAFFIC_INTERVAL = 1000;
  private static final int NUM_STUDENTS = 10;
  private static final int SUCCESS_NO_DATA = 204;

  /**
   * The initial method called when execution begins.
   *
   * @param args An array of command line arguments
   */
  public static void main(String[] args) {
    new Main(args).run();
  }

  private String[] args;

  private Main(String[] args) {
    this.args = args;
  }

  private void run() {
    // Parse command line arguments
    OptionParser parser = new OptionParser();
    parser.accepts("gui");
    parser.accepts("traffic");
    parser.accepts("port").withRequiredArg().ofType(Integer.class)
        .defaultsTo(DEFAULT_PORT);
    OptionSet options = parser.parse(args);

    if (options.has("gui")) {
      runSparkServer((int) options.valueOf("port"));
    }
  }

  private void runSparkServer(int port) {
    Spark.port(port);
//    Spark.externalStaticFileLocation("src/main/resources/static");
    Spark.options("/*", (request, response) -> {
      String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
      if (accessControlRequestHeaders != null) {
        response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
      }

      String accessControlRequestMethod = request.headers("Access-Control-Request-Method");

      if (accessControlRequestMethod != null) {
        response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
      }

      return "OK";
    });

    Spark.before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
    Spark.exception(Exception.class, new ExceptionPrinter());
    Spark.post("/student", new StudentRegistrationHandler());
    Spark.post("/matches", new MatchHandler());
    Spark.post("/courses", new StudentLogInHandler());
  }

  /**
   * Display an error page when an exception occurs in the server.
   */
  private static class ExceptionPrinter implements ExceptionHandler {
    @Override
    public void handle(Exception e, Request req, Response res) {
      res.status(500);
      StringWriter stacktrace = new StringWriter();
      try (PrintWriter pw = new PrintWriter(stacktrace)) {
        pw.println("<pre>");
        e.printStackTrace(pw);
        pw.println("</pre>");
      }
      res.body(stacktrace.toString());
    }
  }

  /**
   * static class for registration.
   */
  private static class StudentRegistrationHandler implements Route {
    @Override
    public Object handle(Request req, Response res) throws Exception {
      DatabaseConnect dbc = new DatabaseConnect();
      MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "frontEndStudents");
      MongoCollection<Document> courseCollection =
          dbc.databaseConnect("CourseDB", "frontEndCourses");
      HandleStudent handleStudent = new HandleStudent();
      JSONObject data = new JSONObject(req.body());
      if (handleStudent.authenticateUser(data.getString("email"), collection) == null) {
        Student student = handleStudent.create(data, courseCollection);
        handleStudent.sendNewStudent(student, collection);
        dbc.close();
        res.status(200);
        return 200;
      } else {
        //student already exists in the database
        dbc.close();
        res.status(400);
        return 400;
      }
    }
  }

  /**
   * static class for login.
   */
  private static class StudentLogInHandler implements Route {
    @Override
    public Object handle(Request req, Response res) throws Exception {
      DatabaseConnect dbc = new DatabaseConnect();
      MongoCollection<Document> collection = dbc.databaseConnect("CourseDB", "frontEndStudents");
      JSONObject data = new JSONObject(req.body());
      HandleStudent handleStudent = new HandleStudent();
      Student student1 = handleStudent.authenticateUser(data.getString("email"), collection);
      if (student1 != null) {
        res.status(200);
        Gson gson = new Gson();
        dbc.close();
        Map<String, List<MatchStudent>> matchStudentsList = student1.getCourseMatches();
        List<String> courseLst = new ArrayList<>();
        for (Course c : student1.getCourseList()) {
          courseLst.add(c.getName());
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("courses", courseLst);
        if (!matchStudentsList.isEmpty()) {
          dataMap.put("currMatches", matchStudentsList);
        } else {
          dataMap.put("currMatches", null);
        }
        return gson.toJson(dataMap);
      } else {
        //student not found, should be checked on frontend
        dbc.close();
        res.status(404);
        return 404;
      }
    }
  }

  /**
   * static class for a matches.
   */
  private static class MatchHandler implements Route {
    @Override
    public Object handle(Request req, Response res) throws Exception {
      DatabaseConnect dbc = new DatabaseConnect();
      MongoCollection<Document> collection = dbc.databaseConnect("CourseDB",
          "frontEndStudents");
      MongoCollection<Document> courseCollection = dbc.databaseConnect("CourseDB",
          "frontEndCourses");
      JSONObject data = new JSONObject(req.body());
      HandleStudent handleStudent = new HandleStudent();
      HandleCourses handleCourses = new HandleCourses();
      CallCommands cC = new CallCommands();
      Student student1 = handleStudent.authenticateUser(data.getString("email"), collection);
      Course course = handleCourses.getCourse(data.getString("course"), courseCollection);
      String matchType = data.getString("matchPref");
      if (matchType.equals("random")) {
        if (student1 != null && course != null) {
          res.status(200);
          String match = cC.getRandomMatch(student1, course, collection);
          if (match == null) {
            res.status(SUCCESS_NO_DATA);
            return SUCCESS_NO_DATA;
          }
          dbc.close();
          return match;
        } else {
          dbc.close();
          res.status(404);
          return 404;
        }
      }
      if (matchType.equals("best")) {
        if (student1 != null && course != null) {
          res.status(200);
          String match = cC.getBestMatch(student1, course, NUM_STUDENTS, collection);
          dbc.close();
          if (match == null) {
            res.status(SUCCESS_NO_DATA);
            return SUCCESS_NO_DATA;
          }
          return match;
        } else {
          dbc.close();
          res.status(404);
          return 404;
        }
      }
      dbc.close();
      res.status(404);
      return 404;
    }
  }
}
