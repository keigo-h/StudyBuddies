import {React, useState} from 'react'
import axios from "axios";
import EmailForm from '../IndividualComponents/EmailForm';

function Results() {
  const [enteredEmail, setEnteredEmail] = useState("");
  const [pastMatches, setPastMatches] = useState("");

  const getResults = async (e) => {
    e.preventDefault();
    try {
      // handle courses 
      let config = {
        headers: {
            "Content-Type": "application/json",
            'Access-Control-Allow-Origin': '*',
        }
      }
      const toSend = JSON.stringify({
        userEmail: enteredEmail,
      });
      let res = await axios.get("http://localhost:5678/results", toSend, config);
      // get response and turn into json 
      let pastMatches = res.data["pastMatches"];
      setPastMatches(pastMatches);
    } catch (err) {
      console.log(err);
    }
  }

  const emailChangeHandler = (event) => {
    setEnteredEmail(event.target.value);
  };

  return (
    <form onSubmit={getResults}>
      <h3>
        Check Results here
      </h3>
      <EmailForm value={enteredEmail} onChange={emailChangeHandler} />
      <div className="submit-button">
        <button type="submit">Get Results</button>
      </div>
      <div className="pastMatches">{pastMatches.map((x) => {return(<p>x</p>)})}</div>
    </form>
  )
}

export default Results