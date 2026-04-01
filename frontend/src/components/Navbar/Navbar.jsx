import { NavLink } from "react-router-dom"
import "./navbar.css";
function Navbar() {

    return (
       <div className="navbar">
        <h2 className="logo">Performance Analyzer</h2>

        <div className="nav-links">
        <NavLink to="/" className="nav-link">
        Home
        </NavLink>

        <NavLink to="/analytics" className="nav-link">
            Analytics
        </NavLink>

         </div>
       </div>
    )
}

export default Navbar;