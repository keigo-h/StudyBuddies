import { NavLink } from 'react-router-dom';

import classes from './MainHeader.module.css';

/**
 * This function returns a header with a navigation bar that has a link to the login page and a link to
 * the sign out page
 * @returns A header with a nav bar with two links.
 */
const MainHeader = (props) => {
  return (
    <header className={classes.header}>

      <nav>
        <ul>
          <h2>Study Buddy Matcher2</h2>
          <li>
            <NavLink activeClassName={classes.active} to='/login'>
              Sign in
            </NavLink>
          </li>
          {props.isLogin && props.handleLogout &&<li>
            <NavLink activeClassName={classes.active} to='/login' onClick={props.handleLogout}>
              Sign out
            </NavLink>
          </li>}
        </ul>
      </nav>
    </header>
  );
};

export default MainHeader;
