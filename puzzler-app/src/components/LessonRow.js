import {Component} from "react";

export class LessonRow extends Component {
    render() {
        const lessonRow = this.props.lessonRow;

        return <>
            <tr key={lessonRow.id}>
                <th>{lessonRow.id}</th>
                <td><a href="/" className="text-light">{lessonRow.subjectName}</a></td>
                <td><a href="/" className="text-light">{lessonRow.name}</a></td>
                <td><a href="/" className="text-light">{lessonRow.title}</a></td>
            </tr>
        </>;
    }
}