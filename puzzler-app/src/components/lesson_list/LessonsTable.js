import {Component} from "react";
import {LessonsTableHeader} from "./LessonsTableHeader";
import axios from "axios";
import {LessonsRow} from "./LessonsRow";

export class LessonsTable extends Component {
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
        const tableRows = lessonRows.map((lessonsRow) =>
            <LessonsRow key={lessonsRow.id} lessonRow={lessonsRow}/>
        );

        return <>
            <h1 className="text-center">Список уроков</h1>
            <table className="table table-dark">
                <LessonsTableHeader/>
                <tbody>
                <>{tableRows}</>
                </tbody>
            </table>
        </>;
    }
}