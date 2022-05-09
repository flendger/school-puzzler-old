export function isEmpty(value) {
    return !(value > 0);
}

export function stringIsEmpty(value) {
    return !value || value.trim().length === 0;
}
