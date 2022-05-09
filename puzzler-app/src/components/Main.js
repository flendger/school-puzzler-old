import {Component} from "react";
import {Outlet} from "react-router-dom";
import {MainHeader} from "./MainHeader";
import {LessonLogin} from "./LessonLogin";

export default class Main extends Component {
    render() {
        return <div className="container mt-1">
            <MainHeader/>
            <LessonLogin/>
            <Outlet/>
        </div>;
    }
}