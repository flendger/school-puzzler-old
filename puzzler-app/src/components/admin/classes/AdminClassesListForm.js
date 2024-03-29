import {AdminClassesEditClassForm} from "./AdminClassesEditClassForm";
import {useState} from "react";
import {EntityList} from "../listform/EntityList";
import {deleteEntity, getEntityList} from "./AdminClassDataFunctions";
import {AdminClassesListHeader} from "./AdminClassesListHeader";
import {AdminClassesListTableRow} from "./AdminClassesListTableRow";

export function AdminClassesListForm() {
    const [currentId, setCurrentId] = useState();
    const [showEditor, setShowEditor] = useState(false);
    const [searchParams, setSearchParams] = useState({});

    const entityActions = {
        getEntityList: getEntityList,
        deleteEntity: deleteEntity
    };

    const formActions = {
        onOpenEditor: onOpenEditor,
        onCloseEditor: onCloseEditor,
        getListRow: getListRow
    };

    function onCloseEditor() {
        setShowEditor(false);
        setSearchParams({});
    }

    function onOpenEditor(id) {
        setCurrentId(id);
        setShowEditor(true);
    }

    function getListRow(classData) {
        return <AdminClassesListTableRow classData={classData}/>;
    }

    return <>
        <EntityList entityActions={entityActions}
                    formActions={formActions}
                    params={searchParams}
                    entityListHeader = {<AdminClassesListHeader/>}
        />
        <AdminClassesEditClassForm currentId={currentId} show={showEditor} onClose={onCloseEditor}/>
    </>;
}