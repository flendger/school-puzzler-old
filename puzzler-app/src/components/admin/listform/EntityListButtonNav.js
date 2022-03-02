import {ButtonToolbar} from "react-bootstrap";

export function EntityListButtonNav(props) {
    const customNav = props.customNav ? props.customNav : <></>;
    return <>
        <ButtonToolbar className="mt-2">
            <div className="button-group">
                <button type="button" onClick={() => props.onOpenEditor()} className="btn btn-secondary btn-sm">Добавить</button>
            </div>
            {customNav}
        </ButtonToolbar>
    </>;
}