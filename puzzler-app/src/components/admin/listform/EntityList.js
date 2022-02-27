import {EntityListButtonNav} from "./EntityListButtonNav";
import {EntityListTable} from "./EntityListTable";
import {useEffect, useState} from "react";

export function EntityList(props) {

    const [classesData, setClassesData] = useState([]);

    const entityActions = props.entityActions;
    const formActions = props.formActions;

    useEffect(() => onReloadData(), []);

    function onOpenEditor(id) {
        formActions.onOpenEditor(id);
    }

    function onReloadData() {
        entityActions.getEntityList(setClassesData, props.params);
    }

    function onDeleteEntity(id) {
        entityActions.deleteEntity(id, onReloadData);
    }
    return <>
        <div className="mx-1">
            <EntityListButtonNav onOpenEditor={onOpenEditor}/>
            <EntityListTable classesData={classesData}
                             onOpenEditor={onOpenEditor}
                             onDeleteEntity={onDeleteEntity}
                             entityListHeader={props.entityListHeader}
                             getListRow={formActions.getListRow}
            />
        </div>
    </>;
}