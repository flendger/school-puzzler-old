import axios from "axios";
import {getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";
import {ctxPath} from "../../../requests";

const endPoint = ctxPath + '/students/lkey';

export function getSubjects(onSuccess) {
    axios.get(endPoint + "/subjects", getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}

export function getLessons(subjectId, onSuccess) {
    const params = {subjectId: subjectId};
    const configWithHeader = getConfigWithHeader({params: params});

    axios.get(endPoint + "/lessons", configWithHeader)
        .then((response) => {
            onSuccess(response.data);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}

export function getClasses(onSuccess) {
    axios.get(endPoint + "/classes", getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}

export function generateKey(keyRequest, onSuccess) {
    axios.post(endPoint, keyRequest, getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}

export function deleteKey(keyValue, onSuccess) {
    axios.delete(endPoint + "/" + keyValue, getRequestHeader())
        .then(() => {
            onSuccess(keyValue);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}