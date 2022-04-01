import axios from "axios";
import {deleteJwtRequest, saveJwtRequest} from "../tokenUtils";

const ctxPath = '/puzzler/api/v1/auth';

export function login(username, password, afterCallback) {
    axios.post(ctxPath, {username: username, password: password})
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