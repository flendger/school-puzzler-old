import {AdminClassesDeleteButton} from "./AdminClassesDeleteButton";
import {AdminClassesEditButton} from "./AdminClassesEditButton";

export function AdminClassesTableRow(props) {

    const classData = props.classData;

    return <tr>
        <th scope="row" className="text-center">{props.rowNum}</th>
        <td>{classData.name}</td>
        <td className="text-center">
            <AdminClassesEditButton currentId={classData.id} onOpenEditor={props.openEditor}/>
            <AdminClassesDeleteButton currentId={classData.id} onDeleteEntity={props.deleteEntity}/>
        </td>
    </tr>;
}