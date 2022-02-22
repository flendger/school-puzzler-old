export function AdminClassesEditClassForm(props) {
    function changeName(e) {
        const value = e.target.value;

        props.onNameChanged(value);
    }

    return <>
        <div className="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabIndex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div className="modal-dialog">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="staticBackdropLabel">Редактирование учебного класса</h5>
                        <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"/>
                    </div>
                    <div className="modal-body">
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="basic-addon1">Название</span>
                            </div>
                            <input type="text" onChange={changeName} value={props.currentClass.name}
                                   className="form-control"
                                   aria-label="Username" aria-describedby="basic-addon1"/>
                        </div>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                        <button type="button" className="btn btn-primary">Сохранить</button>
                    </div>
                </div>
            </div>
        </div>
    </>;
}