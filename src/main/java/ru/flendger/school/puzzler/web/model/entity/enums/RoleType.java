package ru.flendger.school.puzzler.web.model.entity.enums;

public enum RoleType {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER"),
    ROLE_STUDENT("STUDENT");

    private final String simpleName;

    RoleType(String simpleName) {
        this.simpleName = simpleName;
    }

    public String simpleName() {
        return simpleName;
    }
}
