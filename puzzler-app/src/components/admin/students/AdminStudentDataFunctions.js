import axios from "axios";
import {getAuthorizationHeader, getConfigWithHeader, getRequestHeader} from "../../../tokenUtils";
import {ctxPath} from "../../../requests";

const endPoint = ctxPath + '/students/students';

//todo move request functions to one file

export function getEntityList(changeState, params) {
    const configWithHeader = getConfigWithHeader({params: params});

    axios.get(endPoint, configWithHeader)
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

export function downloadStudents(formData) {
    const authHeader = getAuthorizationHeader();
    const mergeHeader = {...authHeader, ...{
            'content-type': 'multipart/form-data'
        }};
    const fileConfig = {
        headers: mergeHeader
    };

    axios.post(endPoint + '/download', formData, fileConfig)
        .then((response) => {
            console.log(response.data.message);
        });
}