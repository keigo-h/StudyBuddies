import React, { useContext, useState, useEffect } from "react";
import { auth } from "./fire";

const AuthContext = React.createContext();
/**
 * It returns the value of the AuthContext object
 * @returns The AuthContext
 */

export function useAuth() {
  return useContext(AuthContext);
}

export function AuthProvider({ children }) {
  const [currentUser, setCurrentUser] = useState();
  const [loading, setLoading] = useState(true);

  /**
   * It takes an email and password, and returns a promise that will resolve with the user object if
   * the signup succeeds, or reject with an error if it fails
   * @param email - The email address of the user.
   * @param password - The password for the new account.
   * @returns the promise that is returned by the createUserWithEmailAndPassword function.
   */
  function signup(email, password) {
    return auth.createUserWithEmailAndPassword(email, password);
  }

  /**
   * It takes two arguments, email and password, and returns a promise that resolves to the user object
   * if the login is successful
   * @param email - The email address of the user.
   * @param password - The password for the user.
   * @returns The promise is being returned.
   */
  function login(email, password) {
    return auth.signInWithEmailAndPassword(email, password);
  }

  /**
   * The function logout() is called when the user clicks the logout button. The function then calls
   * the signOut() function from the auth object
   * @returns The user's authentication status.
   */
  function logout() {
    return auth.signOut();
  }

  /**
   * It takes an email address as an argument and sends a password reset email to that address
   * @param email - The email address with the password you want to reset.
   * @returns A promise
   */
  function resetPassword(email) {
    return auth.sendPasswordResetEmail(email);
  }

  /**
   * It takes an email address as an argument and updates the current user's email address
   * @param email - The new email address.
   * @returns The promise is being returned.
   */
  function updateEmail(email) {
    return currentUser.updateEmail(email);
  }

  /**
   * The function updatePassword() takes a password as an argument and returns the
   * currentUser.updatePassword() function
   * @param password - The new password for the user.
   * @returns The current user's password is being updated.
   */
  function updatePassword(password) {
    return currentUser.updatePassword(password);
  }

  /* Listening for changes in the authentication state. */
  useEffect(() => {
    const unsubscribe = auth.onAuthStateChanged((user) => {
      setCurrentUser(user);
      setLoading(false);
    });

    return unsubscribe;
  }, []);

  const value = {
    currentUser,
    login,
    signup,
    logout,
    resetPassword,
    updateEmail,
    updatePassword,
  };

  return (
    <AuthContext.Provider value={value}>
      {!loading && children}
    </AuthContext.Provider>
  );
}
