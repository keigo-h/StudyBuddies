/**
 * This function takes in a value and an onChange function as props, and returns a dropdown menu with
 * the options of the different study locations
 * @param props - the props passed to the component
 * @returns A dropdown menu with the options of the different study locations.
 */
const StudySpaceForm = (props) => {
  return (
    <div className="formElement">
      <label>Study Location</label>
      <select
        name="locations"
        id="locations"
        value={props.value}
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
    </div>
  );
};

export default StudySpaceForm;
