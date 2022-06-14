import {Button, Card, Form} from "react-bootstrap";
import {useState} from "react";
import {getStudents, login} from "./StudentAuthDataFunctions";
import {isEmpty, stringIsEmpty} from "../../validationUtils";
import alert from "bootstrap/js/src/alert";
import {useNavigate} from "react-router";

export function LessonLogin() {
    const [students, setStudents] = useState([]);
    const [studentId, setStudentId] = useState({});
    const [keyValue, setKeyValue] = useState("");

    const navigate = useNavigate();

    function onKeyValueChanged(e) {
        const keyValue = e.target.value;
        if (stringIsEmpty(keyValue)) {
            setKeyValue("");
            return;
        }

        setKeyValue(keyValue);
        getStudents(keyValue, setStudents);
    }

    function onLoginClick() {
        if (stringIsEmpty(keyValue)) {
            alert("Для входа в урок введите ключ урока");
            return;
        }

        if (isEmpty(studentId)) {
            alert("Для входа в урок необходимо выбрать студента");
            return;
        }

        const loginRequest = {
            keyValue: keyValue,
            studentId: studentId
        };
        login(loginRequest, () => navigate("/lesson"));
    }

    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Доступ к уроку</b></Card.Header>
        <Card.Body>
            <Form onSubmit={(event) => event.preventDefault()}>
                <Form.Group className="mb-3" controlId="formLessonKey">
                    <Form.Label>Ключ</Form.Label>
                    <Form.Control
                        size="sm"
                        type="text"
                        placeholder="Введите ключ урока"
                        onBlur={onKeyValueChanged}
                    />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeyStudent">
                    <Form.Label>Студент</Form.Label>
                    <Form.Select
                        size="sm"
                        onChange={(e) => setStudentId(e.target.value)}>
                        <option value={0}>Выберите студента</option>
                        {students.map((student) => {
                            return <option key={student.id} value={student.id}>{student.name}</option>
                        })}
                    </Form.Select>
                </Form.Group>
                <div className="text-center">
                    <Button variant="primary" type="button" onClick={onLoginClick}>
                        Войти
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}