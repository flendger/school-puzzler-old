import {AdminClassesTableHeader} from "./AdminClassesTableHeader";
import {AdminClassesTableRow} from "./AdminClassesTableRow";

export function AdminClassesTable(props) {
    const classesRows = props.classesData?.map((currentClass) => {
        return <AdminClassesTableRow key={currentClass.id} rowNum={currentClass.id} classData={currentClass}
                                     onOpenEditor={props.onOpenEditor} onDeleteEntity={props.onDeleteEntity}/>
    });

    return <>
        <table className="table table-dark mt-2">
            <AdminClassesTableHeader/>
            <tbody>
            {classesRows}
            </tbody>
        </table>
    </>;
}