/**
 * It returns a div with a label and an input element. The input element is a number input with a
 * minimum value of 1 and a maximum value of 50. The value of the input element is set to the value of
 * the props.value argument, and the onChange event is set to the props.onChange argument
 * @param props - This is the object that contains the data that is passed to the component.
 * @returns A div with a label and an input.
 */
const MinTimeForm = (props) => {
  return (
    <div className="formElement">
      <label>Minimum time willing to spend (hours) </label>
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

export default MinTimeForm;
