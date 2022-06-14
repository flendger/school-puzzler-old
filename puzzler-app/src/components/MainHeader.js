import {Button, Container, Nav, Navbar} from "react-bootstrap";
import {useNavigate} from "react-router";
import {getUsername, isAdmin, isLogin} from "../storageUtils";
import {logout} from "./AuthRequests";
import {logoutStudent} from "./student/student_logout/StudentLogoutDataFunctions";

export function MainHeader() {
    const navigate = useNavigate();

    function onLogout() {
        if (!isAdmin()) {
            logoutStudent(() => navigate("/"));
        } else {
            logout(() => navigate("/"));
        }
    }

    return <Navbar bg="dark" expand="sm" variant="dark">
        <Container>
            <Navbar.Brand href="/">Puzzler</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav"/>

            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto">
                    {isLogin()&&!isAdmin() ? <Nav.Link href="/lesson">Урок</Nav.Link> : ""}
                    {isAdmin() ? <Nav.Link href="/admin">Администрирование</Nav.Link> : ""}
                </Nav>
            </Navbar.Collapse>

            {!isLogin() ? <Navbar.Collapse className="justify-content-end">
                <Button variant="dark" onClick={() => navigate("login")}>Вход</Button>
            </Navbar.Collapse> : ""}
            {isLogin() ? <Navbar.Collapse className="justify-content-end">
                <Navbar.Text>
                    Пользователь: {getUsername()}
                </Navbar.Text>
                <Button variant="dark" onClick={onLogout}>Выход</Button>
            </Navbar.Collapse> : ""}
        </Container>
    </Navbar>;
}