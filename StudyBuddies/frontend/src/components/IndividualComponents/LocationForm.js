/**
 * This function is a form element that allows the user to select their living location
 * @param props - an object that contains the following:
 * @returns A dropdown menu with the options of North Campus, South Campus, Mid Campus, and Off Campus.
 */
const LocationForm = (props) => {
  return (
    <div className="formElement">
      <label>Living Location </label>
      <select
        name="locations"
        id="locations"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="north">North Campus</option>
        <option value="south">South Campus</option>
        <option value="mid">Mid Campus</option>
        <option value="off">Off Campus</option>
      </select>
    </div>
  );
};

export default LocationForm;
