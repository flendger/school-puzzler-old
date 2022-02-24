import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useState} from "react";
import {EntityList} from "../EntityList";
import {deleteEntity, getEntityList} from "./AdminClassDataFunctions";
import {AdminClassesListHeader} from "./AdminClassesListHeader";

export function AdminClassesListForm() {
    const [currentId, setCurrentId] = useState();
    const [showEditor, setShowEditor] = useState(false);

    const entityActions = {
        getEntityList: getEntityList,
        deleteEntity: deleteEntity
    };

    const formActions = {
        onOpenEditor: onOpenEditor,
        onCloseEditor: onCloseEditor
    };


    function onCloseEditor() {
        setShowEditor(false);
    }

    function onOpenEditor(id) {
        setCurrentId(id);
        setShowEditor(true);
    }

    return <>
        <EntityList entityActions={entityActions}
                    formActions={formActions}
                    entityListHeader = {<AdminClassesListHeader/>}
        />
        <AdminClassesEditClassForm currentId={currentId} show={showEditor} onClose={onCloseEditor}/>
    </>;
}