import {Component} from "react";
import {LessonTableHeader} from "./LessonTableHeader";
import {LessonTableRows} from "./LessonTableRows";
import axios from "axios";

export class LessonTable extends Component {
    constructor(props, context) {
        super(props, context);

        this.state = {
            lessonRows: [
                // {
                //     id: 1,
                //     name: "Урок 1",
                //     title: "Заголовок урока 1",
                //     subjectName: "Химия"
                // }
                ]
        };

        this.updateState = this.updateState.bind(this);
    }

    componentDidMount() {
        this.getLessonsFromServer();
    }

    getLessonsFromServer() {
        axios.get('/api/v1/lesson')
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

        return <>
            <table className="table table-dark">
                <LessonTableHeader/>
                <LessonTableRows lessonRows={lessonRows}/>
            </table>
        </>;
    }
}