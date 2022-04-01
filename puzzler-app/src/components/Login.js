import {Button, Card, Form} from "react-bootstrap";
import {useState} from "react";
import {login} from "./AuthRequests";
import {useNavigate} from "react-router";

export function Login() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    function onLogin(e) {
        e.preventDefault();
        login(username, password, () => navigate("/"));
    }

    return <Card
        style={{width: '18rem'}}
        className="mb-2 position-absolute top-50 start-50 translate-middle"
    >
        <Card.Header><b>Вход</b></Card.Header>
        <Card.Body>
            <Form onSubmit={onLogin}>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Логин</Form.Label>
                    <Form.Control type="text" placeholder="Login" onChange={(e) => setUsername(e.target.value)}/>
                </Form.Group>

                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Пароль</Form.Label>
                    <Form.Control type="password" placeholder="Password" onChange={(e) => setPassword(e.target.value)}/>
                </Form.Group>
                <div className="text-center">
                    <Button variant="primary" type="submit">
                        Войти
                    </Button>
                </div>
            </Form>
        </Card.Body>
    </Card>;
}