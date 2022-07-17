package edu.brown.cs.student.main.Connection;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Class which establishes a connection to the database.
 */
public class DatabaseConnect {

  private final MongoClient mongoClient;

  /**
   * Constructor which establishes a connection.
   */
  public DatabaseConnect() {
    this.mongoClient = clientConnect();
  }

  /**
   * Constructor with a MongoClient to connect to.
   *
   * @param mongoClient the connection
   */
  public DatabaseConnect(MongoClient mongoClient) {
    this.mongoClient = clientConnect();
  }

  /**
   * method which connects the client.
   *
   * @return the connection
   */
  public MongoClient clientConnect() {
    FileParser parser =
        new FileParser("src/main/java/edu/brown/cs/student/main/Connection/password2.txt");
    String password = parser.readNewLine();
//    ConnectionString connectionString = new ConnectionString(
//        "mongodb+srv://admin:"+password+"@cluster0.g3e5x.mongodb.net/myFirstDatabase
//        ?retryWrites=true&w=majority");
    ConnectionString connectionString = new ConnectionString(
        "mongodb+srv://admin:" + password
            + "@cluster0.aednr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    return MongoClients.create(connectionString);
  }

  public MongoCollection<Document> databaseConnect(String db, String collection) {
    MongoDatabase database = this.mongoClient.getDatabase(db);
    return database.getCollection(collection);
  }

  /**
   * Closes the connection to the database.
   */
  public void close() {
    this.mongoClient.close();
  }
}
