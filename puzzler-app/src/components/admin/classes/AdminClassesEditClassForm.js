import {useEffect} from "react";
import {Button, Modal} from "react-bootstrap";

export function AdminClassesEditClassForm(props) {
    function changeName(e) {
        const value = e.target.value;

        props.onNameChanged(value);
    }

    useEffect(() => {
        console.log("hgkghk")
        // handleShow();
    })

    return <>
        <Modal
            show={props.show}
            onHide={props.onClose}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header closeButton>
                <Modal.Title>Редактирование учебного класса</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <span className="input-group-text" id="basic-addon1">Название</span>
                    </div>
                    <input type="text" onChange={changeName} value={props.currentClass.name}
                           className="form-control"
                           aria-label="Username" aria-describedby="basic-addon1"/>
                </div>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={props.onClose}>Закрыть</Button>
                <Button variant="primary">Сохранить</Button>
            </Modal.Footer>
        </Modal>
    </>;
}