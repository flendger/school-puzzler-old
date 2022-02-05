import {Component} from "react";
import {LessonTableHeader} from "./LessonTableHeader";
import {LessonTableRows} from "./LessonTableRows";

export class LessonTable extends Component {
    constructor(props, context) {
        super(props, context);

        this.state = {
            lessonRows: [
                {
                    id: 1,
                    name: "Урок 1",
                    title: "Заголовок урока 1",
                    subjectName: "Химия"
                }]
        };
    }

    render() {
        const lessonRows = this.state.lessonRows;

        return <>
            <table className="table table-dark">
                <LessonTableHeader/>
                <LessonTableRows lessonRows={lessonRows}/>
            </table>
        </>;
    }
}