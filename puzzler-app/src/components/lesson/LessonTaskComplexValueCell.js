export function LessonTaskComplexValueCell(props) {
    const taskValue = props.taskValue;
    const value1 = taskValue.value1;
    const value2 = taskValue.value2;
    const value3 = taskValue.value3;

    return <td>
        <div className="input-group input-group-sm justify-content-center">
            <input type="number" className="form-control text-right" defaultValue={value1}/>
            <div className="input-group-prepend">
                <span className="input-group-text">x</span>
            </div>
            <input className="form-control text-right col-sm-2 min-w60" type="number" defaultValue={value2}/>
            <div className="input-group-prepend">
                <span className="input-group-text">^</span>
            </div>
            <input className="form-control text-right col-sm-2 min-w60" type="number" defaultValue={value3}/>
        </div>
    </td>;
}