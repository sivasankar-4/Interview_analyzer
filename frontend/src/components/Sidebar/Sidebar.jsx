import { NavLink } from "react-router-dom"
import "./sidebar.css"

function Sidebar () {

    return (
      
        <div className="sidebar"> 
        <h2 className="logo">Performance Analyzer</h2>

        <NavLink to="/" className="nav-item">
            Dashboard
        </NavLink>

        <NavLink to="/analytics" className="nav-item">
            Analytics
        </NavLink>
         

        </div>

    );
}

export default Sidebar;