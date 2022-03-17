import {Button, Form, InputGroup} from "react-bootstrap";
import {useState} from "react";
import axios from "axios";
import {downloadStudents} from "./AdminStudentDataFunctions";

export function StudentSearch(props) {
    const [className, setClassName] = useState("");
    const [fileData, setFileData] = useState(null);

    function onDownloadButton(e) {
        e.preventDefault();

        if (!fileData) {
            return;
        }

        const url = '/api/v1/admin/students/download';

        const formData = new FormData();
        formData.append('data', fileData);

        downloadStudents(formData);
    }

    function onFileSelect(e) {
        setFileData(e.target.files[0]);
    }

    return <>
        <InputGroup className="col-sm-2">
            <Form.Control size="sm" type="text" className="ms-2" placeholder="Класс"
                          onChange={(e) => setClassName(e.target.value)}/>
            <Button variant="outline-success" size="sm" onClick={() => props.findByClassName(className)}>Найти</Button>
        </InputGroup>
        <Form onSubmit={onDownloadButton}>
            <Form.Group controlId="formFileSm" className="ms-3">
                <InputGroup>
                    <Form.Control type="file" size="sm" onChange={onFileSelect}/>
                    <Button type="submit" variant="btn btn-secondary btn-sm" size="sm">Загрузить</Button>
                </InputGroup>
            </Form.Group>
        </Form>
    </>;
}