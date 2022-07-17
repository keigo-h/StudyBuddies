import Select from "react-select";
import { useState } from "react";

const courseOptions = [
  { value: "AFRI 0090", label: "AFRI 0090" },
  { value: "AFRI 0670", label: "AFRI 0670" },
  { value: "AFRI 0840", label: "AFRI 0840" },
  { value: "APMA 0200", label: "APMA 0200" },
  { value: "APMA 0350", label: "APMA 0350" },
  { value: "APMA 0360", label: "APMA 0360" },
  { value: "CSCI 0020", label: "CSCI 0020" },
  { value: "CSCI 0081", label: "CSCI 0081" },
  { value: "CSCI 0082", label: "CSCI 0082" },
  { value: "ECON 0110", label: "ECON 0110" },
  { value: "ECON 0170", label: "ECON 0170" },
  { value: "ECON 0710", label: "ECON 0710" },
];

/**
 * It's a React component that renders a Select component from the react-select library
 * @returns A form element that allows the user to select a course from a dropdown menu.
 */
const SingleCourseCodeForm = (props) => {
  const [selectedOption, setSelectedOption] = useState([]);

  return (
    <div className="formElement">
      <label>Course to Match on: </label>
      <Select
        value={selectedOption}
        onChange={(v) => (v.length < 2 ? setSelectedOption(v) : null)}
        options={courseOptions}
        placeholder="Select courses from your course schedule"
        noOptionsMessage={() => "Course not found"}
        isMulti
        autoFocus
        isSearchable
        isClearable
      />
    </div>
  );
};

export default SingleCourseCodeForm;
