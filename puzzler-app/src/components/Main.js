import {Component} from "react";
import {Outlet} from "react-router-dom";

export default class Main extends Component {
    render() {
        return <div className="container mt-1">
            <Outlet/>
        </div>;
    }
}