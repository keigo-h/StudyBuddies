/**
 * It returns a div with a label and an input element. The input element has a value and an onChange
 * prop
 * @param props - This is the object that contains all the props that were passed to the component.
 * @returns A div with a label and an input.
 */
const EmailForm = (props) => {
  return (
    <div className="formElement">
      <label>Email </label>
      <input type="text" value={props.value} onChange={props.onChange}></input>
    </div>
  );
};

export default EmailForm;
