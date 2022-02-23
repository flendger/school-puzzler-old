import {AdminClassesButtonNav} from "./AdminClassesButtonNav";
import {AdminClassesTable} from "./AdminClassesTable";
import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useEffect, useState} from "react";
import axios from "axios";

export function AdminClasses() {
    const [currentId, setCurrentId] = useState();

    const [showEditor, setShowEditor] = useState(false);

    function closeEditor() {
        setShowEditor(false);
        reloadData();
    }

    function openEditor(curId) {
        setCurrentId(curId);
        setShowEditor(true);
    }

    const [classesData, setClassesData] = useState([]);

    function reloadData() {
        axios.get('/api/v1/admin/classes')
            .then((response) => {
                setClassesData(response.data);
            })
            .catch((error) => {
                let errMsg = error.response.data.message;
                errMsg = errMsg ? errMsg : error;

                alert(errMsg);
            });
    }

    useEffect(() => reloadData(), []);

    function deleteEntity(id) {
        axios.delete('/api/v1/admin/classes', {
            data: {
                id: id
            }
        })
            .then((response) => {
                alert(response.data.message);
                reloadData();
            })
            .catch((error) => {
                let errMsg = error.response.data.message;
                errMsg = errMsg ? errMsg : error;

                alert(errMsg);
            });
    }

    return <>
        <div className="mx-1">
            <AdminClassesButtonNav openEditor={openEditor}/>
            <AdminClassesTable openEditor={openEditor} classesData={classesData} deleteEntity={deleteEntity}/>
        </div>
        <AdminClassesEditClassForm currentId={currentId} show={showEditor} onClose={closeEditor}/>
    </>;
}