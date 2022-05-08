import axios from "axios";
import {getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";

const ctxPath = '/puzzler/api/v1/admin';

export function getSubjects(onSuccess) {
    axios.get(ctxPath + "/subjects", getRequestHeader())
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

    axios.get(ctxPath + "/lessons", configWithHeader)
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
    axios.get(ctxPath + "/classes", getRequestHeader())
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
    axios.post(ctxPath + "/lkey", keyRequest, getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}

export function deleteKey(keyValue, onSuccess) {
    axios.delete(ctxPath + "/lkey/" + keyValue, getRequestHeader())
        .then(() => {
            onSuccess(keyValue);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}