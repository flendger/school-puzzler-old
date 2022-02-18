export function LessonTaskComplexValueCellReadOnly(props) {
    const taskValue = props.taskValue;
    const value1 = taskValue.value1;
    const value2 = taskValue.value2;
    const value3 = taskValue.value3;

    return <td className="text-center">
        <span>{value1} x {value2} ^ {value3}</span>
    </td>;
}