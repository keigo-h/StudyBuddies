import { Route } from "react-router-dom";
import Form from "../Form/Form";

/**
 * The Signin function is a React component that returns a Route component that returns a header
 * component that returns a h1 component that returns a string
 * @returns A route that will render the signin page.
 */
const Signin = () => {
  return (
    <Route path="/signin">
      <header className="App-header">
        <h1>Sign in here if you already have an account!!</h1>
      </header>
    </Route>
  );
};

export default Signin;
