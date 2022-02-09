import {Component} from "react";
import {LessonTableHeader} from "./LessonTableHeader";
import axios from "axios";
import {LessonRow} from "./LessonRow";

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
                }
            ]
        };

        this.updateState = this.updateState.bind(this);
    }

    componentDidMount() {
        //this.getLessonsFromServer();
    }

    getLessonsFromServer() {
        axios.get('/api/v1/lessons')
            .then(response => {
                this.updateState(response.data);
            })
            .catch(error => {
                alert(error);
            })
    }

    updateState(data) {
        this.setState({
            lessonRows: data
        })
    }

    render() {
        const lessonRows = this.state.lessonRows;
        const tableRows = lessonRows.map((lessonRow) =>
            <LessonRow key={lessonRow.id} lessonRow={lessonRow}/>
        );

        return <>
            <h1 className="text-center">Список уроков</h1>
            <table className="table table-dark">
                <LessonTableHeader/>
                <tbody>
                <>{tableRows}</>
                </tbody>
            </table>
        </>;
    }
}