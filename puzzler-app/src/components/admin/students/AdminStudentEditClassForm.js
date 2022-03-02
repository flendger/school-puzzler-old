import {useState} from "react";
import {Button, Modal} from "react-bootstrap";
import {getEntityData, saveEntity} from "./AdminStudentDataFunctions";
import {getEntityList} from "../classes/AdminClassDataFunctions";

export function AdminStudentEditClassForm(props) {
    const defaultEntityData = {
        id: undefined,
        name: "",
        schoolClass: {
            id: undefined,
            name: ""
        }
    };

    const [currentEntity, setCurrentEntity] = useState(defaultEntityData);

    const [classesList, setClassesList] = useState([]);

    function onClose() {
        props.onClose();
        setCurrentEntity(defaultEntityData);
    }

    function onSave() {
        saveEntity(currentEntity, onClose);
    }

    function onShow() {
        getEntityData(props.currentId, setCurrentEntity, onClose);
        getEntityList(setClassesList);
    }

    function onInputChanged(e) {
        const {name, value} = e.target;
        setCurrentEntity(prevState => ({
            ...prevState,
            [name]: value
        }));
    }

    function onClassChange(e) {
        const {value} = e.target;

        const founded = classesList.find(element => element.id.toString() === value);

        if (founded) {
            setCurrentEntity(
                prevState => ({
                    ...prevState,
                    "schoolClass": founded
                }));
        }
    }

    const id = props.currentId ? props.currentId : "";
    const name = currentEntity.name ? currentEntity.name : "";
    const curClassId = currentEntity.schoolClass ? currentEntity.schoolClass.id : "";

    return <>
        <Modal
            show={props.show}
            onShow={onShow}
            onHide={onClose}
            backdrop="static"
            keyboard={false}
        >
            <Modal.Header closeButton>
                <Modal.Title>Редактирование студента</Modal.Title>
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
                        <span className="input-group-text" id="basic-addon1">Имя</span>
                    </div>
                    <input type="text" name="name" value={name} onChange={onInputChanged}
                           className="form-control"/>
                </div>
                <div className="input-group mb-3">
                    <div className="input-group-prepend col-sm-3">
                        <span className="input-group-text" id="basic-addon1">Класс</span>
                    </div>
                    <select value={curClassId} onChange={onClassChange} className="form-select">
                        <option value="">Выберите класс</option>
                        {classesList.map((curClass) => {
                            return <option key={curClass.id} value={curClass.id}>{curClass.name}</option>;
                        })}
                    </select>
                </div>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={onClose}>Закрыть</Button>
                <Button variant="primary" onClick={onSave}>Сохранить</Button>
            </Modal.Footer>
        </Modal>
    </>;
}