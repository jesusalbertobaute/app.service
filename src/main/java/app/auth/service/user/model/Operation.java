package app.auth.service.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Operation {
    USER_READ("USER_READ"),
    USER_UPDATE("USER_UPDATE"),
    USER_CREATE("USER_CREATE"),
    USER_DELETE("USER_DELETE"),
    PRODUCT_READ("PRODUCT_READ"),
    PRODUCT_UPDATE("PRODUCT_UPDATE"),
    PRODUCT_CREATE("PRODUCT_CREATE"),
    PRODUCT_DELETE("PRODUCT_DELETE");

    @Getter
    private final String operation;
}