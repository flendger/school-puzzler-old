import {AdminClassesButtonNav} from "./AdminClassesButtonNav";
import {AdminClassesTable} from "./AdminClassesTable";
import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useState} from "react";

export function AdminClasses() {
    const [currentId, setCurrentId] = useState();

    const [showEditor, setShowEditor] = useState(false);

    function closeEditor() {
        setShowEditor(false);
    }

    function openEditor(curId) {
        setCurrentId(curId);
        setShowEditor(true);
    }

    return <>
        <div className="mx-1">
            <AdminClassesButtonNav openEditor={openEditor}/>
            <AdminClassesTable openEditor={openEditor}/>
        </div>
        <AdminClassesEditClassForm currentId={currentId} show={showEditor} onClose={closeEditor}/>
    </>;
}