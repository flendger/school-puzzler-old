import {useEffect, useState} from "react";
import {StudentsLessonKeyTableRow} from "./StudentsLessonKeyTableRow";
import {getList} from "./StudentsLessonKeysDataFunctions";

export function StudentsLessonKeysRows() {
    const [studentLessonKeyRows, setRows] = useState([]);

    useEffect(() => {
        getList(setRows);
    }, []);

    function onDelete(id) {
        console.log(id);
    }

    const tableRows = studentLessonKeyRows?.map((rowData) => {
        return <StudentsLessonKeyTableRow key={rowData.id} rowData={rowData} onDelete={onDelete}/>
    });

    return <tbody>
    {tableRows}
    </tbody>;
}