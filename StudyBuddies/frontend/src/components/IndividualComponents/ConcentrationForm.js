/**
 * It returns a div that contains a label and a dropdown menu
 * @param props - an object that contains the following:
 * @returns A dropdown menu with all the concentrations
 */
const ConcentrationForm = (props) => {
  return (
    <div className="formElement">
      <label>Concentration </label>
      <select
        name="concentrations"
        id="conc"
        value={props.value}
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
        <option value="Cognitive Neuroscience">Cognitive Neuroscience</option>
        <option value="Philosophy">Philosophy</option>
        <option value="Other">Other</option>
      </select>
    </div>
  );
};

export default ConcentrationForm;
