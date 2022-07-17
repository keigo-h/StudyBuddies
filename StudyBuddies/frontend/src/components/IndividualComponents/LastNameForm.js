const LastNameForm = (props) => {

    return (
        <div className="formElement">
          <label>Last Name </label>
          <input
            type="text"
            value = {props.value}
            onChange = {props.onChange}
          />
        </div>
    );
};
export default LastNameForm;