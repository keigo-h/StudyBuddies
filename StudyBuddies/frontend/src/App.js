import "./App.css";
import "./components/Form/Form.css";
import React, { useState } from "react";
import Signup from "./components/Pages/Signup";
import { Route } from "react-router-dom";
import MainHeader from "./components/UI/MainHeader";
import GetMatch from "./components/Pages/GetMatch";
import Login from "./components/Login";
import fire from "./components/fire";
import { useHistory } from "react-router-dom";
import axios from "axios";
require("firebase/auth");
/**
 * A component that combines all the other components.
 */
function App() {
  const history = useHistory();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [hasAccount, setHasAccount] = useState(false);
  const [accessToken, setAccessToken] = useState("");
  const [isLogin, setIsLogin] = useState(false);
  const [courses, setCourses] = useState([]);
  const [pastMatches, setPastMatches] = useState({});

  /**
   * It clears the error messages
   */
  const clearErrors = () => {
    setEmailError("");
    setPasswordError("");
  };

  /**
   * Fetch the courses for the user. This will be called in handleLogin after 
   * a succesful login and the received courses data will be used in getMatch so that 
   * the user will only be able to select their course. 
   */
  const getCoursesOfUser = async () => {
    const toSend = JSON.stringify({
      email : email,
    });
    let config = {
      headers: {
        "Content-Type": "application/json",
        'Access-Control-Allow-Origin': '*',
      }
    };
    let res = await axios.post("http://localhost:5678/courses", toSend, config);
    if (res.status === 404) {
      // something went wrong. 
      console.log("There was an error in retrieving the user's courses");
    } else {
      let courses = res.data["courses"];
      let pastMatches = res.data["currMatches"];
      setPastMatches(pastMatches);
      setCourses(courses);
    }
  }
  /**
   * The function handles the login process by taking the email and password from the form, and then
   * using the firebase authentication API to sign in the user. If the user is successfully signed in,
   * the function will set the access token to the state, and then redirect the user to the match page
   */
  async function handleLogin() {
    clearErrors();
    let isSuccess = true;
    fire
      .auth()
      .signInWithEmailAndPassword(email, password)
      .catch((err) => {
        console.log(err);
        isSuccess = false;
        switch (err.code) {
          case "auth/invalid-email":
            isSuccess = false;
            break;
          case "auth/user-disabled":
            isSuccess = false;
            break;
          case "auth/user-not-found":
            isSuccess = false;
            setEmailError(err.message);
            break;
          case "auth/wrong-password":
            isSuccess = false;
            setPasswordError(err.message);
            break;
          default:
            isSuccess = false;
            break;
        }
      })
      .then(async (response) => {
        console.log(response);
        console.log(isSuccess);
        if (isSuccess === true) {
          let tmp = response.user._delegate.accessToken;
          setAccessToken(tmp);
          setIsLogin(true);
          // get courses for the specific user 
          getCoursesOfUser();
          let endpointUrl = "/?q=" + response.user._delegate.accessToken;
          // history.push({endpointUrl, state: { email: email }});
          history.push({
            pathname: '/match',
            search: endpointUrl,
            state: { email: email, courses: courses, matches: pastMatches }
          })
        }
      });
  }
  /**
   * The function first checks if the email is a Brown email. If it is, it clears any errors that may
   * have been displayed previously, and then it creates a new user with the email and password. If the
   * user is successfully created, it redirects the user to the signup page. If the user is not
   * successfully created, it displays an error message
   */
  async function handleSignup() {
    if (!/@brown.edu\s*$/.test(email)) {
      alert("Only an email with @brown.edu domain can be used for signup.");
    } else {
      clearErrors();
      let isSuccess = true;
      fire
        .auth()
        .createUserWithEmailAndPassword(email, password)
        .catch((err) => {
          isSuccess = false;
          console.log("Error is", err);
          switch (err.code) {
            case "auth/email-already-in-use":
              alert("Email already registered!");
              isSuccess = false;
              break;
            case "auth/invalid-email":
              isSuccess = false;
              setEmailError(err.message);
              break;
            case "auth/weak-password":
              isSuccess = false;
              setPasswordError(err.message);
              break;
            default:
              isSuccess = false;
              break;
          }
        })
        .then(async (response) => {
          console.log(response);
          console.log(isSuccess);
          if (isSuccess === true) {
            let endpointUrl = "/signup";
            history.push(endpointUrl);
          }
        });
    }
  }
  /**
   * It sets the isLogin state to false, which will trigger a re-render of the App component, which
   * will then render the Login component instead of the Home component
   */
  const handleLogout = () => {
    setIsLogin(false);
    // fire.auth.signOut();
  };

  return (
    <div className="App">
      <MainHeader handleLogout={handleLogout} isLogin={isLogin} />
      <main>
        <Route path="/login">
          <Login
            email={email}
            setEmail={setEmail}
            password={password}
            setPassword={setPassword}
            handleLogin={handleLogin}
            handleSignup={handleSignup}
            hasAccount={hasAccount}
            setHasAccount={setHasAccount}
            emailError={emailError}
            passwordError={passwordError}
          />
        </Route>
        <Route exact path="/signup">
          <Signup email={email} />
        </Route>
        <Route path="/match" accessToken={accessToken}>
          <GetMatch email={email} courses={courses} pastMatches={pastMatches}/>
        </Route>
      </main>
    </div>
  );
}
export default App;