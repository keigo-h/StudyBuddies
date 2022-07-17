import React from "react";

import { Route } from "react-router-dom";


/**
 * It renders a login page that allows users to sign in or sign up
 * @param props - an object that contains all the parameters passed in from the parent component
 * @returns A Route component that renders a div with className "login"
 */
const Login = (props) => {
  const {
    email,
    setEmail,
    password,
    setPassword,
    handleLogin,
    handleSignup,
    hasAccount,
    setHasAccount,
    emailError,
    passwordError,
  } = props;

  const mystyle = {
    padding: "50px",
    // fontSize: "200 px",
  };


  return (
    <Route path="/login">
      <div className="login" style={mystyle}>
        <div className="loginContainer">
          <label>Username (your brown.edu email address) </label>
          <input
            type="text"
            autoFocus
            required
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          ></input>
          <p className="errorMsg">{emailError}</p>
          <label>Password (must be more than 5 characters) </label>
          <input
            type="password"
            required
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          ></input>
          <p className="errorMsg">{passwordError}</p>
          <div className="buttonContainer">
            {hasAccount ? (
              <>
                <button onClick={handleLogin}>Sign in</button>
                <p>Don't have an account? <span style={{color: "red", cursor:'pointer'}} onClick={() => {setHasAccount(!hasAccount)}}>Sign up</span></p>
              </>
            ) : (
              <>
                <button onClick={handleSignup}>Sign up</button>
                <p>Have an account? <span style={{color: "red", cursor:'pointer'}} onClick={() => {setHasAccount(!hasAccount)}}>Sign in</span></p>
              </>
            )}
          </div>
        </div>
      </div>
    </Route>
  );
};

export default Login;
