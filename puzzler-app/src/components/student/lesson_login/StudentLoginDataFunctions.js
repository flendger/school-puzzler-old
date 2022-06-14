import axios from "axios";
import {getRequestHeader, saveJwtRequest} from "../../../tokenUtils";
import {ctxPath} from "../../../requests";

const endPoint = ctxPath + '/students/login';

export function getStudents(keyValue, onSuccess) {
    axios.get(endPoint + "/classes/" + keyValue, getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}

export function login(keyRequest, onSuccess) {
    axios.post(endPoint, keyRequest, getRequestHeader())
        .then((response) => {
            saveJwtRequest(response.data);
            onSuccess();
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}