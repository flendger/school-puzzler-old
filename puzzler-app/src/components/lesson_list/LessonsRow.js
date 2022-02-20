import {Component} from "react";
import {Link} from "react-router-dom";

export class LessonsRow extends Component {
    render() {
        const lessonRow = this.props.lessonRow;

        return <>
            <tr key={lessonRow.id}>
                <th>{lessonRow.id}</th>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light">{lessonRow.subjectName}</Link>
                </td>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light">{lessonRow.name}</Link>
                </td>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light">{lessonRow.title}</Link>
                </td>
            </tr>
        </>;
    }
}