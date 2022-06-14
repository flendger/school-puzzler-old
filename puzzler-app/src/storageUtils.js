const usernameKey = "puzzlerUsername";
const tokenKey = "puzzlerToken";
const isAdminKey = "puzzlerIsAdmin";

export function saveUsername(username) {
    localStorage.setItem(usernameKey, username);
}

export function saveToken(token) {
    localStorage.setItem(tokenKey, token);
}

export function saveIsAdmin(isAdmin) {
    localStorage.setItem(isAdminKey, "" + isAdmin);
}

export function deleteStorage() {
    localStorage.setItem(usernameKey, "")
    localStorage.setItem(tokenKey, "");
    localStorage.setItem(isAdminKey, "false");
}

export function getUsername() {
    return localStorage.getItem(usernameKey);
}

export function getIsAdmin() {
    return localStorage.getItem(isAdminKey);
}

export function isLogin() {
    const username = getUsername();
    return !!username;
}

export function isAdmin() {
    const username = getUsername();
    const isAdmin = getIsAdmin();
    return !!username && isAdmin === "true";
}
