import {AdminNavBar} from "./AdminNavBar";
import {Outlet} from "react-router-dom";

export function AdminMain() {
    return <div className="container mt-1">
        <AdminNavBar/>
        <Outlet/>
    </div>;
}