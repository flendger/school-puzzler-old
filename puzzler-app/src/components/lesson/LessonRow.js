import {LessonTaskValueCell} from "./LessonTaskValueCell";
import {LessonTaskComplexValueCell} from "./LessonTaskComplexValueCell";
import {LessonTaskValueCellReadOnly} from "./LessonTaskValueCellReadOnly";
import {LessonTaskComplexValueCellReadOnly} from "./LessonTaskComplexValueCellReadOnly";

export function LessonRow(props) {
    const task = props.task;
    const taskValues = task.values;
    const valueCells = taskValues.map((taskValue) => {
            if (taskValue.valueType === 'NUMBER') {
                if (taskValue.accessible) {
                    return <LessonTaskValueCell key={taskValue.id} taskValue={taskValue}/>
                } else {
                    return <LessonTaskValueCellReadOnly key={taskValue.id} taskValue={taskValue}/>
                }
            } else {
                if (taskValue.accessible) {
                    return <LessonTaskComplexValueCell key={taskValue.id} taskValue={taskValue}/>
                } else {
                    return <LessonTaskComplexValueCellReadOnly key={taskValue.id} taskValue={taskValue}/>
                }
            }
        }
    );

    return <tr key={task.id}>
        <th scope="row" className="text-center">{task.id}</th>
        <td className="text-center">{task.title}</td>
        <>{valueCells}</>
    </tr>;
}