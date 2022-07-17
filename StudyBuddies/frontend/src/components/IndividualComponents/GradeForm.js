/**
 * It renders a dropdown menu that allows the user to select between letter grades and S/NC
 * @param props - an object that contains the following properties:
 * @returns A dropdown menu with two options: Letter Grade and S/NC
 */
const GradeForm = (props) => {
  return (
    <div className="formElement">
      <label>Grade Mode </label>
      <select
        name="grades"
        id="grade"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="letterGrade">Letter Grade</option>
        <option value="snc">S/NC</option>
      </select>
    </div>
  );
};

export default GradeForm;
