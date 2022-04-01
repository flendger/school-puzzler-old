import axios from "axios";
import {saveToken} from "../tokenUtils";

const ctxPath = '/puzzler/api/v1/auth';

export function login(username, password, afterCallback) {
    //todo auth post, save token and redirect
    axios.post(ctxPath, {username: username, password: password})
        .then((response) => {
            saveToken(response.data);
            afterCallback();
        })
        .catch(error => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        })
}