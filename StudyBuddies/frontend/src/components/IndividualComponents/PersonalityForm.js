/**
 * It's a function that returns a div with a label, a select element, and a bunch of option elements
 * @param props - This is the object that contains all the properties that were passed to the
 * component.
 * @returns A div with a label and a select element.
 */
const PersonalityForm = (props) => {
  return (
    <div className="formElement">
      <label>Personality Type </label>
      <select
        name="personalities"
        id="personality"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="ISTJ">ISTJ (The Inspector)</option>
        <option value="ISTP">ISTP (The Crafter) </option>
        <option value="ISFJ">ISFJ (The Protector) </option>
        <option value="ISFP">ISFP (The Artist) </option>
        <option value="INFJ">INFJ (The Advocate) </option>
        <option value="INFP">INFP (The Mediator) </option>
        <option value="INTJ">INTJ (The Architect) </option>
        <option value="INTP">INTP (The Thinker) </option>
        <option value="ESTP">ESTP (The Persuader) </option>
        <option value="ESTJ">ESTJ (The Director) </option>
        <option value="ESFP">ESFP (The Performer) </option>
        <option value="ESFJ">ESFJ (The Caregiver) </option>
        <option value="ENFP">ENFP (The Champion) </option>
        <option value="ENFJ">ENFJ (The Giver) </option>
        <option value="ENTP">ENTP (The Debater) </option>
        <option value="ENTJ">ENTJ (The Commander) </option>
      </select>
    </div>
  );
};

export default PersonalityForm;
