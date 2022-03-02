import {Button, Form, InputGroup} from "react-bootstrap";
import {useState} from "react";

export function StudentSearch(props) {
    const [className, setClassName] = useState("");

    return <InputGroup className="col-sm-2">
        <Form.Control size="sm" type="text" className="ms-2" placeholder="Класс"
                      onChange={(e) => setClassName(e.target.value)}/>
        <Button variant="outline-success" size="sm" onClick={() => props.findByClassName(className)}>Найти</Button>
    </InputGroup>;
}