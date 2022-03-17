import axios from "axios";
import {getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";

const ctxPath = '/api/v1/admin/classes';

export function getEntityList(changeState) {
    axios.get(ctxPath, getRequestHeader())
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
    axios.delete(ctxPath, getConfigWithHeader({
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
    let path = ctxPath + '/' + (id ? id : 'new');
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
    axios.post(ctxPath, entity, getRequestHeader())
        .then(() => {
            onSuccess();
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}