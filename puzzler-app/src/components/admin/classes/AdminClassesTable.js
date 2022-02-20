import {AdminClassesTableHeader} from "./AdminClassesTableHeader";
import {AdminClassesTableRow} from "./AdminClassesTableRow";

export function AdminClassesTable() {
    return <table className="table table-dark mt-2">
        <AdminClassesTableHeader/>
        <tbody>
        <AdminClassesTableRow/>
        </tbody>
    </table>;
}