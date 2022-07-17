import React from 'react'

function MatchForm(props) {
  const mystyle = {
    padding: "20px",
};


  return (
    <div className="formElement" style={mystyle}>
      <label>Choose how you get matched: </label>
      <select
        name="locations"
        id="locations"
        value={props.value}
        onChange={props.onChange}
      >
        <option value="best">Get The Best Matches</option>
        <option value="random">Get One Random Match</option>
      </select>
    </div>
  )
}

export default MatchForm