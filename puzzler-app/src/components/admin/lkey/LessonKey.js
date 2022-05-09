import {Button, Card, Form} from "react-bootstrap";
import {useEffect, useState} from "react";
import {generateKey, getClasses, getLessons, getSubjects} from "./AdminLessonKeyDataFunctions";
import {useNavigate} from "react-router";

export function LessonKey() {
    const [subjects, setSubjects] = useState([]);

    const [lessons, setLessons] = useState([]);
    const [lessonId, setLessonId] = useState(null);

    const [schoolClasses, setSchoolClasses] = useState([]);
    const [schoolClassId, setSchoolClassId] = useState(null);

    useEffect(() => {
        getSubjects(setSubjects);
        getClasses(setSchoolClasses);
    }, []);

    function onSubjectSelect(e) {
        const id = e.target.value;

        if (isEmpty(id)) {
            setLessons([]);
            setLessonId(null);
        }

        getLessons(id, setLessons);
    }

    function onGenerateClick() {
        if (isEmpty(lessonId) || isEmpty(schoolClassId)) {
            alert("Не все поля заполнены!!!");
            return;
        }

        const keyRequest = {
            lessonId: lessonId,
            schoolClassId: schoolClassId
        };
        generateKey(keyRequest, showKeyInfo);
    }

    const navigate = useNavigate();

    function showKeyInfo(keyInfo) {
        navigate('/admin/lkey/' + keyInfo.keyValue, {state: keyInfo});
    }

    function isEmpty(value) {
        return !(value > 0);
    }

    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Генерация ключа урока</b></Card.Header>
        <Card.Body>
            <Form onSubmit={event => event.preventDefault()}>
                <Form.Group className="mb-3" controlId="formLessonKeySubject">
                    <Form.Label>Предмет</Form.Label>
                    <Form.Select size="sm" onChange={onSubjectSelect}>
                        <option value={0}>Выберите предмет</option>
                        {subjects.map((subject) => {
                            return <option key={subject.id} value={subject.id}>{subject.name}</option>
                        })}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeyLesson">
                    <Form.Label>Урок</Form.Label>
                    <Form.Select size="sm" onChange={(e) => setLessonId(e.target.value)}>
                        <option value={0}>Выберите Урок</option>
                        {lessons.map((lesson) => {
                            return <option key={lesson.id} value={lesson.id}>{lesson.name}</option>
                        })}
                    </Form.Select>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeySchoolClass">
                    <Form.Label>Класс</Form.Label>
                    <Form.Select size="sm" onChange={(e) => setSchoolClassId(e.target.value)}>
                        <option value={0}>Выберите класс</option>
                        {schoolClasses.map((schoolClass) => {
                            return <option key={schoolClass.id} value={schoolClass.id}>{schoolClass.name}</option>
                        })}
                    </Form.Select>
                </Form.Group>
                <div className="text-center">
                    <Button variant="primary" type="button" onClick={onGenerateClick}>
                        Сгенерировать
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}