import {Component} from "react";
import {LessonTable} from "./LessonTable";

export default class Main extends Component {
    render() {
       return <div className="container">
           <h1 className="text-center">Список уроков</h1>
           <LessonTable/>
       </div>;
    }
}