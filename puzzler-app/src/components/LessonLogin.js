import {Button, Card, Form} from "react-bootstrap";

export function LessonLogin() {
    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Доступ к уроку</b></Card.Header>
        <Card.Body>
            <Form>
                <Form.Group className="mb-3" controlId="formLessonKey">
                    <Form.Label>Ключ</Form.Label>
                    <Form.Control size="sm" type="text" placeholder="Введите ключ урока"/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formLessonKeyStudent">
                    <Form.Label>Студент</Form.Label>
                    <Form.Select size="sm" onChange={(e) => console.log(e.target.value)}>
                        <option value={0}>Выберите студента</option>
                        {/*{schoolClasses.map((schoolClass) => {*/}
                        {/*    return <option key={schoolClass.id} value={schoolClass.id}>{schoolClass.name}</option>*/}
                        {/*})}*/}
                    </Form.Select>
                </Form.Group>
                <div className="text-center">
                    <Button variant="primary" type="button">
                        Войти
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}