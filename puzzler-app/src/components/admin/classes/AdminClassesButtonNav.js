export function AdminClassesButtonNav(props) {
    function openEditor() {
        props.openEditor();
    }

    return <>
        <div className="button-group mt-2">
            <button type="button" onClick={openEditor} className="btn btn-secondary btn-sm">Добавить</button>
        </div>
    </>;
}