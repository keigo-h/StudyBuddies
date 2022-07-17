/**
 * It returns a div with a label and an input element. The input element has a type of number, a
 * minimum value of 1, a maximum value of 50, a value of props.value, and an onChange function of
 * props.onChange
 * @param props - This is the object that contains the properties that are passed to the component.
 * @returns A div with a label and an input.
 */
const MaxTimeForm = (props) => {
  return (
    <div className="formElement">
      <label>Maximum time willing to spend (hours) </label>
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

export default MaxTimeForm;
