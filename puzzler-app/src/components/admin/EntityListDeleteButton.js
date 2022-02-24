export function EntityListDeleteButton(props) {
    return <button type="button" className="btn btn-danger btn-sm"
                   onClick={() => props.onDeleteEntity(props.currentId)}>Удалить</button>;
}