import {EntityListDeleteButton} from "./EntityListDeleteButton";
import {EntityListEditButton} from "./EntityListEditButton";

export function EntityListTableRow(props) {

    const classData = props.classData;

    return <tr>
        <th scope="row" className="text-center">{classData.id}</th>
        <td>{classData.name}</td>
        <td className="text-center">
            <EntityListEditButton currentId={classData.id} onOpenEditor={props.onOpenEditor}/>
            <EntityListDeleteButton currentId={classData.id} onDeleteEntity={props.onDeleteEntity}/>
        </td>
    </tr>;
}