import {EntityListDeleteButton} from "../listform/EntityListDeleteButton";

export function StudentsLessonKeyTableRow(props) {
    const rowData = props.rowData;

    return <tr>
        <th scope="row" className="text-center">{rowData.id}</th>
        <td className="text-center">{rowData.keyValue}</td>
        <td className="text-center">{rowData.loginDateLocal}</td>
        <td className="text-center">{rowData.studentName}</td>
        <td className="text-center">{rowData.lessonName}</td>
        <td className="text-center">
            {<EntityListDeleteButton currentId={rowData.id} onDeleteEntity={props.onDelete}/>}
        </td>
    </tr>;
}