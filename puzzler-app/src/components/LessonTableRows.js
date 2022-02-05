import {Component} from "react";
import {LessonRow} from "./LessonRow";

export class LessonTableRows extends Component {

    render() {
        const lessonRows = this.props.lessonRows;
        const tableRows = lessonRows.map((lessonRow) =>
            <LessonRow key={lessonRow.id} lessonRow={lessonRow}/>
        );

        return <>
            <tbody>
            <>{tableRows}</>
            </tbody>
        </>;
    }
}