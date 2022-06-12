import axios from "axios";
import {getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";
import {ctxPath} from "../../../requests";

const endPoint = ctxPath + '/students/classes';

export function getEntityList(changeState) {
    axios.get(endPoint, getRequestHeader())
        .then((response) => {
            changeState(response.data);
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

export function getEntityData(id, onSuccess, onFailure) {
    let path = endPoint + '/' + (id ? id : 'new');
    axios.get(path, getRequestHeader())
        .then(response => {
            onSuccess(response.data);
        })
        .catch(error => {
            let errMsg = error.response.data.message;
            errMsg = errMsg ? errMsg : error;
            alert(errMsg);

            onFailure();
        });
}

export function saveEntity(entity, onSuccess) {
    axios.post(endPoint, entity, getRequestHeader())
        .then(() => {
            onSuccess();
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}