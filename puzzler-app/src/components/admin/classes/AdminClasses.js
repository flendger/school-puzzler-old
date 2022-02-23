import {AdminClassesButtonNav} from "./AdminClassesButtonNav";
import {AdminClassesTable} from "./AdminClassesTable";
import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useEffect, useState} from "react";
import {deleteEntity, getEntityList} from "./AdminClassDataFunctions";

export function AdminClasses() {
    const [currentId, setCurrentId] = useState();

    const [showEditor, setShowEditor] = useState(false);

    const [classesData, setClassesData] = useState([]);

    useEffect(() => onReloadData(), []);

    function onCloseEditor() {
        setShowEditor(false);
        onReloadData();
    }

    function onOpenEditor(id) {
        setCurrentId(id);
        setShowEditor(true);
    }

    function onReloadData() {
        getEntityList(setClassesData);
    }

    function onDeleteEntity(id) {
        deleteEntity(id, onReloadData);
    }

    return <>
        <div className="mx-1">
            <AdminClassesButtonNav onOpenEditor={onOpenEditor}/>
            <AdminClassesTable classesData={classesData} onOpenEditor={onOpenEditor} onDeleteEntity={onDeleteEntity}/>
        </div>
        <AdminClassesEditClassForm currentId={currentId} show={showEditor} onClose={onCloseEditor}/>
    </>;
}