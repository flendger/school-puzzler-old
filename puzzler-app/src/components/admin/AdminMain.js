import {AdminNavBar} from "./AdminNavBar";
import {Outlet} from "react-router-dom";

export function AdminMain() {
    return <>
        <AdminNavBar/>
        <Outlet/>
    </>;
}