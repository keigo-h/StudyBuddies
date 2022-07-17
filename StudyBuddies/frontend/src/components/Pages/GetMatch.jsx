import { React, useState, useEffect } from 'react';
import Select from 'react-select';
import axios from "axios";
import "./GetMatches.css";
import MatchForm from '../IndividualComponents/MatchForm';
import { useHistory } from "react-router-dom";
import Results from '../IndividualComponents/Results';

function GetMatch(props) {
  const history = useHistory();
  const email = props.email;
  const [message, setMessage] = useState("");
  const [matchPref, setMatchPref] = useState("random");
  const [chosenCourse, setChosenCourse] = useState([]);
  const [courses, setCourses] = useState([]);
  const [matches, setMatches] = useState([]);
  const [pastMatches, setPastMatches]= useState([]);
  const [displayPastMatches, setDisplayPastMatches] = useState(false);
  const [pastMatch1, setPMatch1] = useState([]);
  const [pastMatch2, setPMatch2] = useState([]);
  const [pastMatch3, setPMatch3] = useState([]);
  const [pastMatch4, setPMatch4] = useState([]);
  const [pastMatch5, setPMatch5] = useState([]);

  const [courseMatchDict, setDict] = useState({
    past1: "",
    past2: "",
    past3: "", 
    past4: "",
    past5: "",
  });
  //let courseMatchDict = {};

  
  let courseOptions = [
    { value: 'AFRI 0090', label: 'AFRI 0090: An Introduction to Africana Studies' },
    { value: 'AFRI 0670', label: 'AFRI 0670: Global Black Radicalism' },
    { value: 'AFRI 0840', label: 'AFRI 0840: Monuments, History, and Memory in the United States.' },
    { value: 'APMA 0200', label: 'APMA 0200: Introduction to Modelling' },
    { value: 'APMA 0350', label: 'APMA 0350: Applied Ordinary Differential Equations' },
    { value: 'APMA 0360', label: 'APMA 0360: Applied Partial Differential Equations I' },
    { value: 'APMA 1650', label: 'APMA 1650: Statistical Inference I' },
    { value: 'APMA 1655', label: 'APMA 1655: Honors Statistical Inference I' },
    { value: 'APMA 1660', label: 'APMA 1660: Statistical Inference II' },
    { value: 'APMA 1710', label: 'APMA 1710: Information Theory' },
    { value: 'CSCI 0020', label: 'CSCI 0020: The Digital World' },
    { value: 'CSCI 0081', label: 'CSCI 0081: TA Apprenticeship: Full Credit' },
    { value: 'CSCI 0082', label: 'CSCI 0082: TA Apprenticeship: Half Credit' },
    { value: 'CSCI 0100', label: 'CSCI 0100: Data Fluency for All' },
    { value: 'CSCI 0111', label: 'CSCI 0111: Computing Foundations: Data' },
    { value: 'CSCI 0112', label: 'CSCI 0112: Computing Foundations: Program Organization' },
    { value: 'CSCI 0150', label: 'CSCI 0150: Introduction to Object-Oriented Programming and Computer Science' },
    { value: 'CSCI 0160', label: 'CSCI 0160: Introduction to Algorithms and Data Structures' },
    { value: 'CSCI 0170', label: 'CSCI 0170: CS: An Integrated Introduction' },
    { value: 'CSCI 0190', label: 'CSCI 0190: Accelerated Introduction to Computer Science' },
    { value: 'CSCI 0200', label: 'CSCI 0200: Program Design with Data Structures and Algorithms' },
    { value: 'CSCI 0220', label: 'CSCI 0220: Introduction to Discrete Structures and Probability' },
    { value: 'CSCI 0320', label: 'CSCI 0320: Introduction to Software Engineering' },
    { value: 'CSCI 0330', label: 'CSCI 0330: Introduction to Computer Systems' },
    { value: 'CSCI 1010', label: 'CSCI 1010: Theory of Computation' },
    { value: 'CSCI 1230', label: 'CSCI 1230: Intro to Computer Graphics' },
    { value: 'CSCI 1410', label: 'CSCI 1410: Artificial Intelligence' },
    { value: 'CSCI 1430', label: 'CSCI 1430: Computer Vision' },
    { value: 'CSCI 1470', label: 'CSCI 1470: Deep Learning' },
    { value: 'ECON 0110', label: 'ECON 0110: Principles of Economics' },
    { value: 'ECON 0710', label: 'ECON 0710: Financial Accounting' },

    { value: 'ECON 1110', label: 'ECON 1110: Intermediate Microeconomics' },
    { value: 'ECON 1210', label: 'ECON 1210: Intermediate Macroeconomics' },

    { value: 'POLS 0110', label: 'POLS 0110: Introduction to Political Thought' },
    { value: 'IAPA 1200', label: 'IAPA 1200: Foundations of Security' },
    
    { value: 'CHEM 0330', label: 'CHEM 0330: Equilibrium, Rate, and Structure' },
    { value: 'CHEM 0350', label: 'CHEM 0350: Organic Chemistry' },
    { value: 'BIOL 0470', label: 'BIOL 0470: Genetics' },
    { value: 'BIOL 0480', label: 'BIOL 0480: Evolutionary Biology' },

    { value: 'ENGN 0030', label: 'ENGN 0030: Introduction to Engineering' },
    { value: 'ENGN 0032', label: 'ENGN 0032: Introduction to Engineering: Design' },
];
  /**
  * This function is used to send the submitted user info to the backend. 
  * @param {*} e 
  */
  const sendData = async (e) => {
    e.preventDefault();
    setDisplayPastMatches(false);
    if (chosenCourse.length === 0) {
      alert("Please make sure to choose a course to get matched on.");
      return;
    } 
    
    try {
      setMessage("Getting matches ...");
      const toSend = JSON.stringify({
        email: email,
        course: storeCourses()[0],
        matchPref: matchPref,
      });
      console.log("TOSEND: ", toSend);
      let config = {
        headers: {
          "Content-Type": "application/json",
          'Access-Control-Allow-Origin': '*',
        }
      }
      let res = await axios.post("http://localhost:5678/matches", toSend, config);
      
//       console.log("DATAAAAAAA", res);
      if (res.status === 204) {
        // no matches found 
        console.log("no matches found");
        setMessage("no matches found ...");
        setMatches([]);
      } else if (res.status === 404) {
        // no student found
      }else {
        let matches = res.data["matches"];
        setMatches(matches);
        setChosenCourse("");
        setMessage("here are your matches: ");
      }
    } catch (err) {
      console.log(err);
    }
  }

  /**
   * Jump to the results page that displays the past matches.
   */
  const showPastMatches = () => {
    let allMatches = [];
    // clean up given data 
    if (props.pastMatches === null) {
      setDisplayPastMatches(false);
      setMessage("no past matches found ...")
    } else {
      let j = 1;
      // loop through courses list to get the matches for each. 
      for (let i = 0; i < props.courses.length; i++) {
        const course = props.courses[i];
        //console.log(course);
        if (props.pastMatches.hasOwnProperty(course)) {
          //console.log("Has matches for :", course);
          const matches = props.pastMatches[course];
          console.log("uofdsfasd", matches[0]);
          //console.log("matches", matches);
          // allMatches.push({
          //   [course]: matches,
          // });
          if (j === 1) {
            setPMatch1(matches);
            
            courseMatchDict["past1"] = course;
          } else if (j === 2) {
            setPMatch2(matches);
            courseMatchDict["past2"] = course;
          } else if (j === 3) {
            setPMatch3(matches);
            courseMatchDict["past3"] = course;
          } else if (j === 4) {
            setPMatch4(matches);
            courseMatchDict["past4"] = course;
          } else if (j === 5) {
            setPMatch5(matches);
            courseMatchDict["past5"] = course;
          }
          j++;
        }
      }
      console.log("YOOOOOOOO", courseMatchDict["past1"]);
      console.log("yo", courseMatchDict["past2"]);

      console.log("1", pastMatch1);
      console.log("2", pastMatch2);
      console.log("3", pastMatch3);

      setDisplayPastMatches(true);
    }
    setDisplayPastMatches(true);
  }
  //showPastMatches();

  const storeCourses = () => {
    let toReturn = [];
    for (let j = 0; j < chosenCourse.length; j ++) {
      let courseName = chosenCourse[j].value;
      toReturn.push(courseName);
    } 
    return toReturn;
  }

  const matchChangeHandler = (event) => {
    setMatchPref(event.target.value);
  }; 

  const updateCourses = () => {
    let newCourseLst = [];
    courseOptions.map((x) => {
      if (props.courses.indexOf(x.value) != -1) {
        newCourseLst.push(x);
      }
    });
    //console.log(newCourseLst);
    return newCourseLst;
  }

  let coursesBeingTaken = updateCourses();
  return (
    <div>
      <form onSubmit={sendData}>
        <h2 className="pastResultsButton" onClick={showPastMatches}>
        press here for your past matches
        </h2>
        <h2>
          get matches here
        </h2>
        <Select
              value={chosenCourse}
              onChange={(v) => v.length < 2  ? setChosenCourse(v) : null}
              options={coursesBeingTaken}
              placeholder="Select courses from your course schedule"
              noOptionsMessage={() => 'Course not found'}
              isMulti
              autoFocus
              isSearchable
              isClearable
        />
        <MatchForm value={matchPref} onChange={matchChangeHandler} />
        <div className="submit-button">
          <button type="submit"><strong>get matches</strong></button>
        </div>
        <div className="message">{message ? <p>{message}</p> : null}</div>
        <div className="newMatches">{matches.map((x) => {
          if (matches.length != 0) {
          return (
            <div>
              <h4>{x["name"]}</h4>
              <h5>{x["email"]}</h5>
              <p>{x["classYear"]}</p>
            </div>)
          }
          })}
        </div>
        <div className="pM1">{pastMatch1.map((x) => {
            if (displayPastMatches && pastMatch1.length != 0) {
              const courseName = courseMatchDict["past1"];
              console.log("4", courseName);
              return(
              <div>
                <h3>{courseMatchDict["past1"]}</h3>
                <h4>{x["name"]}</h4>
                <h5>{x["email"]}</h5>
                <p>{x["classYear"]}</p>
              </div>
            )}
          })}
        </div>
        <div className="pM2">{pastMatch2.map((x) => {
            if (displayPastMatches && pastMatch2.length != 0) {
              return(
              <div>
                <h3>{courseMatchDict["past2"]}</h3>
                <h4>{x["name"]}</h4>
                <h5>{x["email"]}</h5>
                <p>{x["classYear"]}</p>
              </div>
            )}
          })}
        </div>
        <div className="pM3">{pastMatch3.map((x) => {
            if (pastMatch3.length != 0) {
              return(
              <div>
                <h3>{courseMatchDict["past3"]}</h3>
                <h4>{x["name"]}</h4>
                <h5>{x["email"]}</h5>
                <p>{x["classYear"]}</p>
              </div>
            )}
          })}
        </div>
        <div className="pM4">{pastMatch3.map((x) => {
            if (pastMatch4.length != 0) {
              return(
              <div>
                <h3>{courseMatchDict["past4"]}</h3>
                <h4>{x["name"]}</h4>
                <h5>{x["email"]}</h5>
                <p>{x["classYear"]}</p>
              </div>
            )}
          })}
        </div>
        <div className="pM5">{pastMatch3.map((x) => {
            if (pastMatch5.length != 0) {
              return(
              <div>
                <h3>{courseMatchDict["past5"]}</h3>
                <h4>{x["name"]}</h4>
                <h5>{x["email"]}</h5>
                <p>{x["classYear"]}</p>
              </div>
            )}
          })}
        </div>
        
      </form>
    </div>
  )
}

export default GetMatch