import {ctxPath} from "../../../requests";
import axios from "axios";
import {getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";

const endPoint = ctxPath + '/students/students-lesson-keys';

export function getList(onSuccess) {
    axios.get(endPoint, getRequestHeader())
        .then((response) => {
            onSuccess(response.data);
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}

export function deleteEntity(id, onSuccess) {
    axios.delete(endPoint, getConfigWithHeader({
        data: {
            id: id
        }
    }))
        .then(() => {
            onSuccess();
        })
        .catch((error) => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;

            alert(errMsg);
        });
}