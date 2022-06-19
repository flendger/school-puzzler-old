import {useEffect, useState} from "react";
import {StudentsLessonKeyTableRow} from "./StudentsLessonKeyTableRow";
import {deleteEntity, getList} from "./StudentsLessonKeysDataFunctions";

export function StudentsLessonKeysRows() {
    const [studentLessonKeyRows, setRows] = useState([]);

    useEffect(() => {onLoad()}, []);

    function onLoad() {
        getList(setRows);
    }

    function onDelete(id) {
        deleteEntity(id, onLoad)
    }

    const tableRows = studentLessonKeyRows?.map((rowData) => {
        return <StudentsLessonKeyTableRow key={rowData.id} rowData={rowData} onDelete={onDelete}/>
    });

    return <tbody>
    {tableRows}
    </tbody>;
}