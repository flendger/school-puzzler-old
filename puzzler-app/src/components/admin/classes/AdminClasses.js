import {AdminClassesButtonNav} from "./AdminClassesButtonNav";
import {AdminClassesTable} from "./AdminClassesTable";
import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useState} from "react";

export function AdminClasses() {
    const [currentClass, setCurrentClass] = useState({
        id: "",
        name: ""
    });

    const [showEditor, setShowEditor] = useState(false);

    function closeEditor() {
        setShowEditor(false);
    }

    function openEditor(curClass) {
        setCurrentClass(curClass);
        setShowEditor(true);
    }

    function nameChanged(name) {
        const newClass = {
            id: currentClass.id,
            name: name
        };

        setCurrentClass(newClass);
        console.log(currentClass)
    }

    return <>
        <div className="mx-1">
            <AdminClassesButtonNav openEditor={openEditor}/>
            <AdminClassesTable openEditor={openEditor}/>
        </div>
        <AdminClassesEditClassForm currentClass={currentClass} onNameChanged={nameChanged} show={showEditor} onClose={closeEditor}/>
    </>;
}