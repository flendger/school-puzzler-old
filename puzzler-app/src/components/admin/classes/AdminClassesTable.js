import {AdminClassesTableHeader} from "./AdminClassesTableHeader";
import {AdminClassesTableRow} from "./AdminClassesTableRow";

export function AdminClassesTable(props) {
    const classesRows = props.classesData?.map((currentClass, index) => {
        return <AdminClassesTableRow key={currentClass.id} rowNum={index + 1} classData={currentClass}
                                     openEditor={props.openEditor} deleteEntity={props.deleteEntity}/>
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