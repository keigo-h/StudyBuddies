/**
 * It returns a div with a label and an input element. The input element has a type of number, a
 * minimum value of 1, a maximum value of 50, a value of the value prop, and an onChange prop that
 * calls the onChange prop
 * @param props - This is the object that contains all the properties that are passed to the component.
 * @returns A div with a label and an input.
 */
const CommitedTimeForm = (props) => {
  return (
    <div className="formElement">
      <label>Time willing to spend (hours) </label>
      <input
        type="number"
        min="1"
        max="50"
        value={props.value}
        onChange={props.onChange}
      />
    </div>
  );
};

export default CommitedTimeForm;
