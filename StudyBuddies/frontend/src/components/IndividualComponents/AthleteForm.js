/**
 * This function returns a div with a label and a select element. The select element has two options,
 * one for non-athletes and one for athletes. The value of the select element is set to the value of
 * the props.value argument, and the onChange event handler is set to the props.onChange argument
 * @param props - This is the props object that is passed to the component.
 * @returns A dropdown menu with two options: Non-Athlete and Athlete.
 */
const AthleteForm = (props) => {
  return (
    <div className="formElement">
      <label>Are you an athlete? </label>
      <select
        name="athletes"
        id="athletes"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="non-athlete">Non-Athlete</option>
        <option value="athlete">Athlete</option>
      </select>
    </div>
  );
};

export default AthleteForm;
