import {Button, Card, Form} from "react-bootstrap";
import {useLocation, useNavigate} from "react-router";
import {deleteKey} from "./AdminLessonKeyDataFunctions";

export function LessonKeyDetail() {

    const location = useLocation();
    const keyInfo = location.state;
    // const keyInfo = {
    //     keyValue: 555777,
    //     lessonId: 1,
    //     lessonName: "les_name",
    //     schoolClassId: 2,
    //     schoolClassName: "class_name",
    //     expiredDateString: "25.05.2022 15:45:35"
    // };

    function onDeleteKeyClick() {
        if (window.confirm('Удалить текущий ключ?')) {
            deleteKey(keyInfo.keyValue, showConfirmation);
        }
    }

    const navigate = useNavigate();
    function showConfirmation(keyValue) {
        window.alert("Ключ " + keyValue + " успешно удален!");
        navigate("/admin");
    }

    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Информация о ключе урока</b></Card.Header>
        <Card.Body>
            <Form onSubmit={event => event.preventDefault()}>
                <Form.Group className="text-center">
                    <Form.Text><h3><b>{keyInfo.keyValue}</b></h3></Form.Text>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeyLesson">
                    <Form.Label>Урок</Form.Label>
                    <Form.Control size="sm" value={keyInfo.lessonName} readOnly/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeySchoolClass">
                    <Form.Label>Класс</Form.Label>
                    <Form.Control size="sm" value={keyInfo.schoolClassName} readOnly/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeySchoolClass">
                    <Form.Label>Срок до</Form.Label>
                    <Form.Control type="datetime" size="sm" value={keyInfo.expiredDateString} readOnly/>
                </Form.Group>
                <div className="text-center">
                    <Button variant="danger" type="button" onClick={onDeleteKeyClick}>
                        Удалить
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}