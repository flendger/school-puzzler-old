export function AdminClassesButtonNav(props) {
    return <>
        <div className="button-group mt-2">
            <button type="button" onClick={() => props.onOpenEditor()} className="btn btn-secondary btn-sm">Добавить</button>
        </div>
    </>;
}