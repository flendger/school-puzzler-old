import axios from "axios";
import {deleteJwtRequest, saveJwtRequest} from "../tokenUtils";
import {ctxPath} from "../requests";

const endPoint = ctxPath + '/login';

export function login(username, password, afterCallback) {
    axios.post(endPoint, {username: username, password: password})
        .then((response) => {
            saveJwtRequest(response.data);
            afterCallback();
        })
        .catch(error => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        })
}

export function logout() {
    deleteJwtRequest();
}