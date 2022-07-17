/**
 * It returns a div with a label and a select element
 * @param props - This is the props object that is passed to the component.
 * @returns A form element with a label, a select element with 4 options, and a value and onChange
 * prop.
 */
const GenderForm = (props) => {
  return (
    <div className="formElement">
      <label>Gender </label>
      <select
        name="gender"
        id="gender"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="male">Male</option>
        <option value="female">Female</option>
        <option value="other">Other</option>
        <option value="none">Prefer not to say</option>
      </select>
    </div>
  );
};

export default GenderForm;
