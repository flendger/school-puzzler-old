import {useState} from "react";
import {Button, Modal} from "react-bootstrap";
import axios from "axios";

export function AdminClassesEditClassForm(props) {
    const defaultClass = {
        id: undefined,
        name: ""
    };
    const [currentClass, setCurrentClass] = useState(defaultClass);

    function onClose() {
        props.onClose();
        setCurrentClass(defaultClass);
    }

    function onSave() {
        axios.post('/api/v1/admin/classes/', currentClass)
            .then(() => {
                onClose();
            })
            .catch(error => {
                alert(error.response.data.message);
            });
    }

    function onShow() {
        const id = props.currentId;

        let path = '/api/v1/admin/classes/' + (id ? props.currentId : 'new');
        axios.get(path)
            .then(response => {
                setCurrentClass(response.data);
            })
            .catch(error => {
                let errMsg = error.response.data.message;
                errMsg = errMsg ? errMsg : error;

                alert(errMsg);

                onClose();
            });

        // const classFromServer = {
        //     id: props.currentId,
        //     name: "NAME"
        // };
        // setCurrentClass(classFromServer);
    }

    function changeModel(e) {
        const {name, value} = e.target;
        setCurrentClass(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    const id = props.currentId ? props.currentId : "";

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
                    <div className="input-group-prepend col-sm-3">
                        <span className="input-group-text" id="basic-addon1">ID</span>
                    </div>
                    <input type="text" value={id} className="form-control" readOnly/>
                </div>
                <div className="input-group mb-3">
                    <div className="input-group-prepend col-sm-3">
                        <span className="input-group-text" id="basic-addon1">Название</span>
                    </div>
                    <input type="text" name="name" value={currentClass.name} onChange={changeModel}
                           className="form-control"
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