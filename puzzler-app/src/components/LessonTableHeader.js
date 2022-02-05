import {Component} from "react";

export class LessonTableHeader extends Component {
    render() {
        return <>
            <thead>
            <tr>
                <th scope="col">№</th>
                <th scope="col">Предмет</th>
                <th scope="col">Название</th>
                <th scope="col">Описание</th>
            </tr>
            </thead>
        </>;
    }
}