import {AdminStudentEditClassForm} from "./AdminStudentEditClassForm";
import {useState} from "react";
import {EntityList} from "../listform/EntityList";
import {deleteEntity, getEntityList} from "./AdminStudentDataFunctions";
import {AdminStudentsListHeader} from "./AdminStudentsListHeader";
import {AdminStudentsListTableRow} from "./AdminStudentsListTableRow";
import {StudentSearch} from "./StudentSearch";

export function AdminStudentsListForm() {
    const [currentId, setCurrentId] = useState();
    const [showEditor, setShowEditor] = useState(false);
    const [searchParams, setSearchParams] = useState({className: ""});

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
        //todo update rows after close
    }

    function onOpenEditor(id) {
        setCurrentId(id);
        setShowEditor(true);
    }

    function getListRow(listData) {
        return <AdminStudentsListTableRow listData={listData}/>;
    }

    function findByClassName(className) {
        setSearchParams({className: className});
    }

    return <>
        <EntityList entityActions={entityActions}
                    formActions={formActions}
                    entityListHeader = {<AdminStudentsListHeader/>}
                    params={searchParams}
                    customNav={<StudentSearch findByClassName={(className)=>findByClassName(className)}/>}
        />
        <AdminStudentEditClassForm currentId={currentId} show={showEditor} onClose={onCloseEditor}/>
        </>;
}