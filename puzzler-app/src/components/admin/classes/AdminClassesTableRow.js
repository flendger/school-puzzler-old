import {Link} from "react-router-dom";
import {AdminClassesDeleteButton} from "./AdminClassesDeleteButton";

export function AdminClassesTableRow(props) {
    function openEditor() {
        props.openEditor({
            id: 1,
            name: "EDIT"
        });
    }

    return <tr>
        <th scope="row" className="text-center">1</th>
        <td>
            <Link to="#" onClick={openEditor} className="text-light" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
                Mark
            </Link>
        </td>
        <td className="text-center">
            <AdminClassesDeleteButton/>
        </td>
    </tr>;
}