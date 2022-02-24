export function EntityListEditButton(props) {
    return <button type="button" onClick={() => props.onOpenEditor(props.currentId)}
                   className="btn btn-success btn-sm me-2">Открыть</button>;
}