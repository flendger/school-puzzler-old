import {useState} from "react";
import {Button, Modal} from "react-bootstrap";

export function AdminClassesEditClassForm(props) {
    const [currentName, setCurrentName] = useState("");

    function onClose() {
        setCurrentName("");
        props.onClose();
    }

    function onSave() {
        console.log({
            id: props.currentId,
            name: currentName
        });
    }

    function onShow() {
        console.log(props.currentId);
        setCurrentName("HELLO")
    }

    return <>
        <Modal
            show={props.show}
            onShow={onShow}
            onHide={onClose}
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
                    <input type="text" defaultValue={currentName} onChange={(e) => setCurrentName(e.target.value)} className="form-control" aria-label="Username"
                           aria-describedby="basic-addon1"/>
                </div>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onClose}>Закрыть</Button>
                <Button variant="primary" onClick={onSave}>Сохранить</Button>
            </Modal.Footer>
        </Modal>
    </>;
}