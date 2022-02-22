export function AdminClassesButtonNav(props) {
    function openEditor() {
        props.openEditor();
    }

    return <>
        <div className="button-group mt-2">
            <button type="button" onClick={openEditor} className="btn btn-secondary btn-sm" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Добавить</button>
        </div>
    </>;
}