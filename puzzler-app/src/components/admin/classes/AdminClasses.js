import {AdminClassesButtonNav} from "./AdminClassesButtonNav";
import {AdminClassesTable} from "./AdminClassesTable";

export function AdminClasses() {
    return <div className="mx-1">
        <AdminClassesButtonNav/>
        <AdminClassesTable/>
    </div>;
}