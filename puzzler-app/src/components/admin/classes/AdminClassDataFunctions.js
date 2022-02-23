import axios from "axios";

const ctxPath = '/api/v1/admin/classes';

export function getEntityList(changeState) {
    axios.get(ctxPath)
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
    axios.delete(ctxPath, {
        data: {
            id: id
        }
    })
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
    axios.get(path)
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
    axios.post(ctxPath, entity)
        .then(() => {
            onSuccess();
        })
        .catch(error => {
            alert(error.response.data.message);
        });
}