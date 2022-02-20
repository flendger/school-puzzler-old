import {LessonTableHeader} from "./LessonTableHeader";
import {LessonRow} from "./LessonRow";

export function LessonTable(props) {
    const lesson = props.lessonData;
    const tasks = lesson.tasks;
    const tableRows =
        tasks?.map(
            (task) =>
                <LessonRow key={task.id} task={task}/>);

    return <table className="table table-dark table-sm">
        <LessonTableHeader lessonHeaders={lesson.headers}/>
        <tbody>
        <>{tableRows}</>
        </tbody>
    </table>;
}