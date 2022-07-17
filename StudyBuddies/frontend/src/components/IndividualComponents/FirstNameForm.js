/**
 * It returns a div with a label and an input. The input has a value and an onChange
 * @param props - This is the object that contains all the properties that were passed to the
 * component.
 * @returns A div with a label and an input.
 */
const FirstNameForm = (props) => {
  return (
    <div className="formElement">
      <label>First Name </label>
      <input type="text" value={props.value} onChange={props.onChange} />
    </div>
  );
};
export default FirstNameForm;
