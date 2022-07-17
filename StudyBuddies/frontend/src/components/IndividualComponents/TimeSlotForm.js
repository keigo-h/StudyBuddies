import ScheduleSelector from "react-schedule-selector";
import { useState } from "react";

/**
 * The TimeSlotForm function is a React component that renders a ScheduleSelector component
 * @param props -
 * @returns A form element with a label and a schedule selector.
 */
const TimeSlotForm = (props) => {
  const [selectedOption, setSelectedOption] = useState([]);
  const startDate = new Date("2021-05-10T14:27:01.444Z");

  return (
    <div className="formElement">
      <label>Time Slots </label>
      <ScheduleSelector
        rowGap={"3 px"}
        dateFormat="dddd"
        startDate={startDate}
        selection={selectedOption}
        numDays={7}
        minTime={0}
        maxTime={24}
        hourlyChunks={1}
        onChange={setSelectedOption}
      />
    </div>
  );
};

export default TimeSlotForm;
