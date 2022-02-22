import {Link} from "react-router-dom";
import {AdminClassesDeleteButton} from "./AdminClassesDeleteButton";

export function AdminClassesTableRow(props) {
    function openEditor() {
        props.openEditor(1); //todo id from model
    }
//todo data from model
    return <tr>
        <th scope="row" className="text-center">1</th>
        <td>
            <Link to="#" onClick={openEditor} className="text-light">
                Mark
            </Link>
        </td>

        {/*//todo add edit button, change Link to text*/}
        {/*//todo delete by id*/}

        <td className="text-center">
            <AdminClassesDeleteButton/>
        </td>
    </tr>;
}