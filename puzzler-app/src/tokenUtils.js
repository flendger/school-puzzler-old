export function getRequestHeader() {
    const authHeader = getAuthorizationHeader();
    return authHeader ? {
        headers: authHeader
    } : {};
}

export function getConfigWithHeader(params) {
    const config = getRequestHeader();
    return  {...config, ...params};
}

export function getAuthorizationHeader() {
    // const token = localStorage.getItem("puzzlerToken");
    //todo from localstorage
    const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHVkZW50Iiwicm9sZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiJdLCJleHAiOjE2NTAxMzY2NjUsImlhdCI6MTY0NzU0NDY2NX0.vKGXrYH6xBXWmyD-Xe2vb5HW-lZZcyFGFILakVkeXK0";
    return token ? {Authorization: `Bearer ${token}`} : {};
}

export function saveToken(token) {
    localStorage.setItem("puzzlerToken", token);
}