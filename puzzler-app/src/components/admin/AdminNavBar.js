import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";

export function AdminNavBar() {
    return <>
        <Navbar bg="dark" variant="dark" expand="sm">
            <Container>
                <Navbar.Brand href="/">Puzzler</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <NavDropdown title="Справочники" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/admin/classes">Школьные классы</NavDropdown.Item>
                            <NavDropdown.Item href="/admin/students">Ученики</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    </>;
}