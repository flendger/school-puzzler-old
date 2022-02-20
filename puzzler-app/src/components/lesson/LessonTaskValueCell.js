export function LessonTaskValueCell(props) {
    const taskValue = props.taskValue;

    return <td>
        <input type="number" className="form-control form-control-sm text-right" defaultValue={taskValue.value1}/>
    </td>;
}