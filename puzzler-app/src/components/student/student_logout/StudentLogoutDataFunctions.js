import {ctxPath} from "../../../requests";
import axios from "axios";
import {deleteJwtRequest, getRequestHeader} from "../../../tokenUtils";

const endPoint = ctxPath + '/students';


export function logoutStudent(onSuccess) {
    axios.post(endPoint + "/logout", getRequestHeader())
        .then(() => {
            deleteJwtRequest();
            onSuccess();
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}