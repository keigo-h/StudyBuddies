import Select from 'react-select';
import React, { useState } from "react";
import axios from "axios";
import ConcentrationForm from "../IndividualComponents/ConcentrationForm";
import FirstNameForm from "../IndividualComponents/FirstNameForm";
import ClassYearForm from "../IndividualComponents/ClassYearForm";
import './Form.css';
import GradeForm from "../IndividualComponents/GradeForm";
import PersonalityForm from "../IndividualComponents/PersonalityForm";
import LastNameForm from "../IndividualComponents/LastNameForm";
import MinTimeForm from "../IndividualComponents/MinTimeForm";
import LocationForm from "../IndividualComponents/LocationForm";
import StudySpaceForm from "../IndividualComponents/StudySpaceForm";
import AthleteForm from "../IndividualComponents/AthleteForm";
import PreferencesForm from "../IndividualComponents/PreferencesForm";
import ScheduleSelector from 'react-schedule-selector';
import GenderForm from '../IndividualComponents/GenderForm';

/*
 * This is a component that renders different input fields such as name, concentration, and email.
 */
const Form = (props) => {

  /**
   * These are the variable fields that user inputs
   */
  const [enteredFirstName, setEnteredFirstName] = useState("");
  const [enteredLastName, setEnteredLastName] = useState("");
  const [enteredYear, setEnteredYear] = useState("");
  const [enteredConcentration, setEnteredConcentration] = useState("");
  const [enteredGradeMode, setEnteredGradeMode] = useState("");
  const [enteredPersonality, setEnteredPersonality] = useState("");
  const [enteredMinTime, setEnteredMinTime] = useState("");
  const [enteredGender, setEnteredGender] = useState("");
  const [enteredLocation, setEnteredLocation] = useState("");
  const [enteredStudySpace, setEnteredStudySpace] = useState("");
  const [enteredAthlete, setEnteredAthlete] = useState("");
  const [courses, setCourses] = useState([]);

  const email = props.email;
  console.log(email)

  const courseOptions = [
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
    { value: 'APMA 0360', label: 'APMA 0360: Applied Partial Differential Equations I' },
    { value: 'APMA 0360', label: 'APMA 0360: Applied Partial Differential Equations I' },
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

  const [preferenceState, setPreferenceState] = useState({
    grade: "Letter Grade",
    gradeModePref: "0",
    classYear: "",
    classYearPref: "0",
    concentration: "Applied Math",
    concPref: "0",
    personality: "ISTJ (The Inspector)",
    personalityPref: "0",
    location: "North Campus",
    locPref: "0",
    athletes: "Non-Athlete",
    athletePref: "0",
    gender: "Male",
    genderPref: "0",
    studyLocation: "CIT",
    studySpacePref: "0",
  })

  const [message, setMessage] = useState("");
  const startDate = new Date("2021-05-10T14:27:01.444Z");
  const [enteredTimeSlots, setTimeSlots] = useState([]);

  /**
   * Function that cleans up the given time array
   */
  const getStartAndEndTimes = (hoursArray) => {
    let toReturn = [];
    if (hoursArray.length != 0) {
      let mostRecentStart = hoursArray[0];
  
      for (let i = 0; i < hoursArray.length; i++) {
        if (i === hoursArray.length - 1) {
          let tuple = [mostRecentStart,  hoursArray[i] + 1];
          toReturn.push(tuple);
        } else {
          const curr = hoursArray[i];
          const next = hoursArray[i+1];
          const difference = next - curr;
          if (difference > 1) {
            let tuple = [mostRecentStart, curr + 1];
            // set mostRecentStart to the next start value
            mostRecentStart = next;
            toReturn.push(tuple);
          } 
        }
      }
    }
    return toReturn;
  }
  /**
   * 
   */
  const restructureTimeSlots = () => {
    // check that timeSlot
    if (enteredTimeSlots != null) {
      // clean data 
      const timeSlotsArray = enteredTimeSlots;
      let mondayArr = [];
      let tuesdayArr = [];
      let wednesdayArr = [];
      let thursdayArr = [];
      let fridayArr = [];
      let saturdayArr = [];
      let sundaryArr = [];

      // loop through timeSlotsArray and register for each 
      for (let i = 0; i < timeSlotsArray.length; i++) {
        const slot = timeSlotsArray[i];
        if (slot.getDay() === 1) {
          // monday 
          mondayArr.push(slot.getHours());
        } else if (slot.getDay() === 2) {
          // tuesday
          tuesdayArr.push(slot.getHours());
        } else if (slot.getDay() === 3) {
          // wednesday
          wednesdayArr.push(slot.getHours());
        } else if (slot.getDay() === 4) {
          // thursday
          thursdayArr.push(slot.getHours());
        } else if (slot.getDay() === 5) {
          // friday
          fridayArr.push(slot.getHours());
        } else if (slot.getDay() ===6) {
          // saturday 
          saturdayArr.push(slot.getHours())
        } else if (slot.getDay() === 0) {
          // sunday
          sundaryArr.push(slot.getHours());
        } 
      }

      let actualMonday = getStartAndEndTimes(mondayArr.sort(function(a,b){ 
        return a - b;
      }));
      let actualTuesday = getStartAndEndTimes(tuesdayArr);
      let actualWednesday = getStartAndEndTimes(wednesdayArr.sort(function(a,b){ 
        return a - b;
      }));
      let actualThursday = getStartAndEndTimes(thursdayArr);
      let actualFriday = getStartAndEndTimes(fridayArr);
      let actualSaturday = getStartAndEndTimes(saturdayArr);
      let actualSunday = getStartAndEndTimes(sundaryArr);

      let timeSlots = {
        monday: actualMonday,
        tuesday: actualTuesday,
        wednesday: actualWednesday,
        thursday: actualThursday,
        friday: actualFriday,
        saturday: actualSaturday,
        sunday: actualSunday,
      } 
      return timeSlots;
  }
}
  /**
   * stores the courses
   * 
   */
  const storeCourses = () => {
    let toReturn = [];
    for (let j = 0; j < courses.length; j ++) {
      let courseName = courses[j].value;
      toReturn.push(courseName);
    } 
    return toReturn;
  }

 /**
   * This function is used to send the submitted user info to the backend. 
   * @param {*} e 
   */
  const sendData = async (e) => {
    e.preventDefault();
    if (enteredFirstName === "" || enteredLastName === "" || enteredYear === "" || enteredMinTime === "" || preferenceState.classYear === "") {
      alert("Please make sure your first name, last name, email, and class year fields are filled.");
      return;
    }
    else {
      try {
        // handle time slots 
        let timeSlots = restructureTimeSlots();
        // handle courses 
        let registeredCourses = storeCourses();
        //console.log(registeredCourses);
        const toSend = JSON.stringify({
          firstName: enteredFirstName,
          lastName: enteredLastName,
          email: email,
          year: enteredYear,
          concentration: enteredConcentration, 
          gradeMode: enteredGradeMode,
          personality: enteredPersonality,
          enteredMinTime: enteredMinTime,
          gender: enteredGender,
          enteredLocation: enteredLocation,
          enteredStudySpace: enteredStudySpace, 
          enteredAthlete: enteredAthlete, 
          timeSlots: timeSlots,
          enteredCourses: registeredCourses,
          preferenceState: preferenceState,
        })
        console.log("TO SEND: ", toSend);
        let config = {
          headers: {
              "Content-Type": "application/json",
              'Access-Control-Allow-Origin': '*',
          }
        }
        // console.log("ENTERED COURSES", enteredCourses);
        //console.log("TIME SLOTS!!!!!!!!!", enteredTimeSlots);
        let res = await axios.post("http://localhost:5678/student", toSend, config);
        // get response and turn into json 
        console.log(res.data);
        //console.log("testing print");
        if (res.status === 200) {
          setEnteredFirstName("");
          setEnteredLastName("");
          setEnteredYear("");
          setEnteredConcentration("");
          setEnteredGradeMode("");
          setEnteredPersonality("");
          setEnteredMinTime("");
          setEnteredLocation("");
          setEnteredGender("");
          setEnteredStudySpace("");
          setEnteredAthlete("");
          setCourses("");
          setPreferenceState("");
          setTimeSlots("");
          setMessage("User created successfully!");
        } else {
          setMessage("Error!");
        }
      } catch (err) {
        console.log(err);
      }
    }
  }

  const handlePreferenceChange = (evt) => {
    const name = evt.target.name;
    const value = evt.target.value;
    setPreferenceState({
      ...preferenceState,
      [name]: value
    })
  }

  /**
   * Handle when a user types in the first name field.
   * @param {*} event
   */
  const firstNameChangeHandler = (event) => {
    setEnteredFirstName(event.target.value);
  };

  /**
   * Handle when a user types in the last name field.
   * @param {*} event
   */
  const lastNameChangeHandler = (event) => {
    setEnteredLastName(event.target.value);
  };

  /**
   * Handle when a user fills in the class year field.
   * @param {*} event
   */
  const yearChangeHandler = (event) => {
    setEnteredYear(event.target.value);
  };
  /**
   * Handle when a user fills in the concentration field.
   * @param {*} event
   */
  const concentrationChangeHandler = (event) => {
    setEnteredConcentration(event.target.value);
  };

  /**
   * It takes the value of the selected option and sets it to the state variable enteredGradeMode
   * @param event - The event that triggered the function.
   */
  const gradeModeChangeHandler = (event) => {
    setEnteredGradeMode(event.target.value);
  };

  /**
   * When the user types something into the personality input field, the enteredPersonality state is
   * updated with the value of the input field.
   * @param event - The event that triggered the function.
   */
  const personalityChangeHandler = (event) => {
    setEnteredPersonality(event.target.value);
  }

  /**
   * When the user changes the value of the input field, update the state of the enteredMinTime
   * variable.
   * @param event - The event object that is passed to the event handler.
   */
  const minTimeChangeHandler = (event) => {
    setEnteredMinTime(event.target.value);
  };

  /**
   * It takes the value of the input field and sets it to the state variable enteredLocation
   * @param event - The event object is a built-in object that contains information about the event
   * that happened.
   */
  const locationChangeHandler = (event) => {
    setEnteredLocation(event.target.value);
  };
  /**
   * The function is called when the user types in the input field. The function takes the value of the
   * input field and sets it to the state variable enteredStudySpace
   * @param event - The event that triggered the function.
   */
  const studySpaceChangeHandler = (event) => {
    setEnteredStudySpace(event.target.value);
  }
  /**
   * When the user types something into the input field, the enteredAthlete state is updated with the
   * value of the input field.
   * @param event - The event that triggered the function.
   */
  const athleteChangeHandler = (event) => {
    setEnteredAthlete(event.target.value);
  };

  const genderChangeHandler = (event) => {
    setEnteredGender(event.target.value);
  };

  return (
    <form onSubmit={sendData}>
      <h3>Step 1.</h3>
      <h3>Fill in your personal information below and tell us about you! </h3>
      <div className="forms">
        <FirstNameForm value={enteredFirstName} onChange={firstNameChangeHandler} />
        <LastNameForm value = {enteredLastName} onChange= {lastNameChangeHandler} />
        <ClassYearForm value={enteredYear} onChange={yearChangeHandler} />
        <ConcentrationForm value={enteredConcentration} onChange={concentrationChangeHandler}/>
        <GradeForm value ={enteredGradeMode} onChange = {gradeModeChangeHandler}/>
        <GenderForm value={enteredGender} onChange={genderChangeHandler}/>
        {/*<label>Courses </label>*/}
        <Select
            value={courses}
            onChange={(v) => v.length < 6 ? setCourses(v) : null}
            options={courseOptions}
            placeholder="Select courses from your course schedule"
            noOptionsMessage={() => 'Course not found'}
            isMulti
            autoFocus
            isSearchable
            isClearable
        />
        {/* <TimeSlotForm class={"timeSlot"}/> */}
        {/* <label>Time Slots </label>*/}
        <ScheduleSelector
            // style={{width:'50%'}}
            rowGap={'3 px'}
            dateFormat="dddd"
            startDate={startDate}
            selection={enteredTimeSlots}
            numDays={7}
            minTime={0}
            maxTime={24}
            hourlyChunks={1}
            onChange={setTimeSlots}
            // renderDateLabel={'1 px'}
        />
        <PersonalityForm value ={enteredPersonality} onChange = {personalityChangeHandler}/>
        <MinTimeForm value = {enteredMinTime} onChange = {minTimeChangeHandler}/>
        <LocationForm value = {enteredLocation} onChange = {locationChangeHandler} />
        <StudySpaceForm value = {enteredStudySpace} onChange = {studySpaceChangeHandler}/> 
        <AthleteForm value = {enteredAthlete} onChange = {athleteChangeHandler}/>
      </div>

        <h3>Step 2.</h3>
        <h3> What type of people do you want to get matched with?
           Please fill in your preferences below.</h3>
        <div className="forms2">
          <PreferencesForm value = {preferenceState} onChange = {handlePreferenceChange} />
        </div>

      <div className="submit-button">
        <button type="submit">Submit Form</button>
      </div>
      <div className="message">{message ? <p>{message}</p> : null}</div>
    </form>
  );
};

export default Form;
