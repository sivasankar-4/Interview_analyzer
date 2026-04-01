

import { Outlet } from "react-router-dom";

import Sidebar from "../components/Sidebar/Sidebar";

function MainLayout({ children }) {
  return (
    <div style={{ display: "flex" }}>
      <Sidebar />

      <div style={{ flex: 1, padding: "20px" }}>
        <Outlet/>
      </div>
    </div>
  );
}

export default MainLayout;