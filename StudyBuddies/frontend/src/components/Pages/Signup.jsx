import { Route } from "react-router-dom";
import Form from "../Form/Form";

/**
 * The Signup function returns a Route component that renders a Form component
 * @returns A Route component with a path of /signup.
 */
const Signup = (props) => {
  return (
    <Route path="/signup">
      <header className="App-header">
        <Form email={props.email}/>
      </header>
    </Route>
  );
};

export default Signup;
