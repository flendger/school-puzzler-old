import {AdminClassesTableHeader} from "./AdminClassesTableHeader";
import {AdminClassesTableRow} from "./AdminClassesTableRow";

export function AdminClassesTable(props) {

    return <>
        <table className="table table-dark mt-2">
            <AdminClassesTableHeader/>
            <tbody>
            <AdminClassesTableRow openEditor={props.openEditor}/>
            </tbody>
        </table>
    </>;
}