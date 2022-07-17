/**
 * This function renders the form for the user to fill out their preferences
 * @param props -
 * @returns A form that allows the user to input their preferences for their study buddy.
 */
const PreferencesForm = (props) => {
  return (
    <div className="formElement">
      <label>Preference level for grade mode </label>
      <select
        name="grade"
        // id="grade"
        value={props.grade}
        onChange={props.onChange}
      >
        <option value="letterGrade">Letter Grade</option>
        <option value="snc">S/NC</option>
      </select>
      <select
        name="gradeModePref"
        // id="gradeModePref"
        value={props.gradeModePref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for class year </label>
      <input
        type="number"
        name="classYear"
        step="0.5"
        min="2022"
        max="2026"
        value={props.classYear}
        onChange={props.onChange}
      ></input>
      <select
        name="classYearPref"
        // id="classYearPref"
        value={props.classYearPref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for concentration </label>
      <select
        name="concentration"
        // id="conc"
        value={props.concentration}
        onChange={props.onChange}
      >
        <option value="APMA">Applied Math</option>
        <option value="Anthropology">Anthropology</option>
        <option value="Africana Studies">Africana Studies</option>
        <option value="Biology">Biology</option>
        <option value="Chemistry">Chemistry</option>
        <option value="Classics">Classics</option>
        <option value="Cognitive Science">Cognitive Science</option>
        <option value="CS">Computer Science</option>
        <option value="Comparative Literature">Comparative Literature</option>
        <option value="Economics">Economics</option>
        <option value="Engineering">Engineering</option>
        <option value="English">English</option>
        <option value="History">History</option>
        <option value="IAPA">IAPA</option>
        <option value="Independent Concentration">
          Independent Concentration
        </option>
        <option value="Math">Math</option>
        <option value="Neuro Science">Neuro Science</option>
        <option value="Philosophy">Philosophy</option>
        <option value="Other">Other</option>
      </select>
      <select
        name="concPref"
        // id="concPref"
        value={props.concPref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for personality </label>
      <select
        name="personality"
        // id="personality"
        value={props.personality}
        onChange={props.onChange}
      >
        <option value="ISTJ">ISTJ (The Inspector)</option>
        <option value="ISTP">ISTP (The Crafter) </option>
        <option value="ISFJ">ISFJ (The Protector) </option>
        <option value="ISFP">ISFP (The Artist) </option>
        <option value="INFJ">INFJ (The Advocate) </option>
        <option value="INFP">INFP (The Mediator) </option>
        <option value="INTJ">INTJ (The Architect) </option>
        <option value="INTP">INTP (The Thinker) </option>
        <option value="ESTP">ESTP (The Persuader) </option>
        <option value="ESTJ">ESTJ (The Director) </option>
        <option value="ESFP">ESFP (The Performer) </option>
        <option value="ESFJ">ESFJ (The Caregiver) </option>
        <option value="ENFP">ENFP (The Champion) </option>
        <option value="ENFJ">ENFJ (The Giver) </option>
        <option value="ENTP">ENTP (The Debater) </option>
        <option value="ENTJ">ENTJ (The Commander) </option>
      </select>
      <select
        name="personalityPref"
        // id="personalityPref"
        value={props.personalityPref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for living location </label>
      <select
        name="location"
        // id="location"
        value={props.location}
        onChange={props.onChange}
      >
        <option value="north">North Campus</option>
        <option value="south">South Campus</option>
        <option value="mid">Mid Campus</option>
        <option value="off">Off Campus</option>
      </select>
      <select
        name="locPref"
        // id="locPref"
        value={props.locPref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for athlete </label>
      <select
        name="athletes"
        // id="athletes"
        value={props.athletes}
        onChange={props.onChange}
      >
        <option value="non-athlete">Non-Athlete</option>
        <option value="athlete">Athlete</option>
      </select>
      <select
        name="athletePref"
        // id="athletePref"
        value={props.athletePref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for gender </label>
      <select
        name="gender"
        // id="gender"
        value={props.gender}
        onChange={props.onChange}
      >
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
        <option value="none">Prefer not to say</option>
      </select>
      <select
        name="genderPref"
        id="genderPref"
        value={props.genderPref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />

      <label>Preference level for study location </label>
      <select
        name="studyLocation"
        // id="studyLocation"
        value={props.studyLocation}
        onChange={props.onChange}
      >
        <option value="cit">CIT</option>
        <option value="gradcenter">Grad Center</option>
        <option value="maingreen">Main Green</option>
        <option value="scili">SciLi</option>
        <option value="ratty">Ratty</option>
        <option value="mochamp">MoChamp</option>
        <option value="rock">Rock</option>
        <option value="other">No Preference</option>
      </select>
      <select
        name="studySpacePref"
        // id="studySpacePref"
        value={props.studySpacePref}
        onChange={props.onChange}
      >
        <option value="0">I don't really care ¯\_(ツ)_/¯ </option>
        <option value="1">Sure </option>
        <option value="2">I could use this in a study buddy </option>
        <option value="3">
          I want this in a study buddy but it's not a must{" "}
        </option>
        <option value="4">It's a must! </option>
      </select>
      <br />
    </div>
  );
};

export default PreferencesForm;
