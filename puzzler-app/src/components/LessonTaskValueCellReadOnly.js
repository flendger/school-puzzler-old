export function LessonTaskValueCellReadOnly(props) {
    const taskValue = props.taskValue;

    return <td className="text-center">
        <span>{taskValue.value1}</span>
    </td>;
}