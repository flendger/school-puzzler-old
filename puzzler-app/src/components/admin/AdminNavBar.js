import {Button, Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import {logout} from "../AuthRequests";
import {useNavigate} from "react-router";
import {getIsAdmin, getUsername} from "../../storageUtils";
import {useEffect} from "react";

export function AdminNavBar() {
    const navigate = useNavigate();

    function onLogout() {
        logout();
        navigate("/");
    }

    useEffect(() => {
        if (getIsAdmin() !== 'true') {
            navigate("/");
        }
    })

    return <>
        <Navbar bg="dark" variant="dark" expand="sm">
            <Container>
                <Navbar.Brand href="/">Puzzler</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <NavDropdown title="Справочники" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/admin/classes">Школьные классы</NavDropdown.Item>
                            <NavDropdown.Item href="/admin/students">Ученики</NavDropdown.Item>
                        </NavDropdown>
                        <NavDropdown title="Уроки" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/admin/lkey">Генерация ключа доступа</NavDropdown.Item>
                            <NavDropdown.Item href="/admin/students-lesson-keys">Активные уроки</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
                <Navbar.Collapse className="justify-content-end">
                    <Navbar.Text>
                        Пользователь: {getUsername()}
                    </Navbar.Text>
                    <Button variant="dark" onClick={onLogout}>Выход</Button>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    </>;
}