import {Button, Container, Navbar} from "react-bootstrap";
import {useNavigate} from "react-router";

export function MainHeader() {
    const navigate = useNavigate();
    return <Navbar bg="dark" expand="sm" variant="dark">
        <Container>
            <Navbar.Brand href="/">Puzzler</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>
            <Navbar.Collapse className="justify-content-end">
                <Button variant="dark" onClick={() => navigate("login")}>Вход</Button>
            </Navbar.Collapse>
        </Container>
    </Navbar>;
}