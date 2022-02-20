import {Link} from "react-router-dom";
import {AdminClassesDeleteButton} from "./AdminClassesDeleteButton";

export function AdminClassesTableRow() {
    return <tr>
        <th scope="row" className="text-center">1</th>
        <td>
            <Link to="#" className="text-light" data-toggle="modal" data-target="#exampleModalCenter">
                Mark
            </Link>
        </td>
        <td className="text-center">
            <AdminClassesDeleteButton/>
        </td>
    </tr>;
}