import {Link} from "react-router-dom";

export function AdminNavBar() {
    return <>
        <nav className="navbar navbar-expand-sm navbar-dark bg-dark">
            <span className="navbar-brand">Puzzler</span>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                <ul className="navbar-nav mr-auto">
                    <li className="nav-item dropdown">
                        <Link className="nav-link dropdown-toggle" to={"#"} id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Справочники
                        </Link>
                        <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                            <Link to={"classes"} className="dropdown-item">Школьные классы</Link>
                            <Link to={"students"} className="dropdown-item">Ученики</Link>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </>;
}