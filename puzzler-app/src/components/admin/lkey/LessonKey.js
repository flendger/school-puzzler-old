import {Button, Card, Form} from "react-bootstrap";
import {useEffect, useState} from "react";
import {getSubjects} from "./AdminLessonKeyDataFunctions";

export function LessonKey() {
    const [subjects, setSubjects] = useState([]);

    useEffect(() => {
        getSubjects(setSubjects)
    }, []);

    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Генерация ключа урока</b></Card.Header>
        <Card.Body>
            <Form>
                <Form.Group className="mb-3" controlId="formLessonKeySubject">
                    <Form.Label>Предмет</Form.Label>
                    <Form.Select size="sm">
                        <option>Выберите предмет</option>
                        {subjects.map((subject) => {
                            return <option key={subject.id} value={subject.id}>{subject.name}</option>
                        })}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeyLesson">
                    <Form.Label>Урок</Form.Label>
                    <Form.Select size="sm">
                        <option>Выберите Урок</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeySchoolClass">
                    <Form.Label>Класс</Form.Label>
                    <Form.Select size="sm">
                        <option>Выберите класс</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </Form.Select>
                </Form.Group>
                <div className="text-center">
                    <Button variant="primary" type="button">
                        Сгенерировать
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}