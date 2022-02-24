import {EntityListTableHeader} from "./EntityListTableHeader";
import {EntityListTableRow} from "./EntityListTableRow";

export function EntityListTable(props) {
    const classesRows = props.classesData?.map((currentClass) => {
        return <EntityListTableRow key={currentClass.id}
                                   classData={currentClass}
                                   onOpenEditor={props.onOpenEditor}
                                   onDeleteEntity={props.onDeleteEntity}
                                   getListRow={props.getListRow}
        />
    });

    return <>
        <table className="table table-dark mt-2">
            <EntityListTableHeader entityListHeader={props.entityListHeader}/>
            <tbody>
            {classesRows}
            </tbody>
        </table>
    </>;
}