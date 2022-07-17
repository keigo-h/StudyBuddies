/**
 * This function returns a div with a label and an input element. The input element has a type of
 * number, a step of 0.5, a min of 2022, a max of 2026, a value of the value prop, and an onChange prop
 * that is the onChange prop
 * @param props - This is the object that contains all the properties that are passed to the component.
 * @returns A form element that allows the user to input a class year.
 */
const ClassYearForm = (props) => {
  return (
    <div className="formElement">
      <label>Class Year </label>
      <input
        type="number"
        step="0.5"
        min="2022"
        max="2026"
        value={props.value}
        onChange={props.onChange}
      ></input>
    </div>
  );
};

export default ClassYearForm;
