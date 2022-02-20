import {LessonHeaderCell} from "./LessonHeaderCell";
import {LessonTaskHeaderCell} from "./LessonTaskHeaderCell";
import {LessonComplexHeaderCell} from "./LessonComplexHeaderCell";

export function LessonTableHeader(props) {
    const headers = props.lessonHeaders;
    const lessonHeaderCells =
        headers?.map((headerCell) => {
            if (headerCell.valueType === 'TASK') {
                return <LessonTaskHeaderCell key={headerCell.id} header={headerCell}/>;
            } else if (headerCell.valueType === 'NUMBER') {
                return <LessonHeaderCell key={headerCell.id} header={headerCell}/>
            } else if (headerCell.valueType === 'COMPLEX_NUMBER') {
                return <LessonComplexHeaderCell key={headerCell.id} header={headerCell}/>
            } else {
                return "";
            }
        });

    return <>
        <thead>
        <tr>
            <th scope="col" className="text-center col-sm-auto">№</th>
            <>{lessonHeaderCells}</>
        </tr>
        </thead>
    </>;
}