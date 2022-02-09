import {Component} from "react";
import {Link} from "react-router-dom";

export class LessonRow extends Component {
    render() {
        const lessonRow = this.props.lessonRow;

        return <>
            <tr>
                <th>{lessonRow.id}</th>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light" key={lessonRow.id}>{lessonRow.subjectName}</Link>
                </td>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light" key={lessonRow.id}>{lessonRow.name}</Link>
                </td>
                <td>
                    <Link to={`lesson/${lessonRow.id}`} className="text-light" key={lessonRow.id}>{lessonRow.title}</Link>
                </td>
            </tr>
        </>;
    }
}