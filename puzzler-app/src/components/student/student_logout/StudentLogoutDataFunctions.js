import {ctxPath} from "../../../requests";
import axios from "axios";
import {deleteJwtRequest, getRequestHeader} from "../../../tokenUtils";

const endPoint = ctxPath + '/students';


export function logoutStudent(onSuccess, onForbidden) {
    axios.post(endPoint + "/logout", {}, getRequestHeader())
        .then(() => {
            deleteJwtRequest();
            onSuccess();
        })
        .catch(error => {
            const status = error.response.status;
            if (status === 403) {
                deleteJwtRequest();
                alert("Сессия истекла. Нужно войти в урок заново.");
                onForbidden();
            } else {
                alert(error.response.data.message);
            }
        });
}