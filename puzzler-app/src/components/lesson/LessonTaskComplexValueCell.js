export function LessonTaskComplexValueCell(props) {
    const taskValue = props.taskValue;
    const value1 = taskValue.value1;
    const value2 = taskValue.value2;
    const value3 = taskValue.value3;

    return <td>
        <div className="input-group input-group-sm">
            <input type="number" className="form-control form-control-sm text-end" defaultValue={value1}/>
            <span className="input-group-text">x</span>
            <div className="col-sm-3">
                <input className="form-control form-control-sm text-end" type="number" defaultValue={value2}/>
            </div>
            <span className="input-group-text">^</span>
            <div className="col-sm-3">
                <input className="form-control form-control-sm text-end" type="number" defaultValue={value3}/>
            </div>
        </div>
    </td>;
}