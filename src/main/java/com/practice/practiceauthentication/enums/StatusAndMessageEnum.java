package com.practice.practiceauthentication.enums;

import lombok.Getter;

@Getter
public enum StatusAndMessageEnum {
    SUCCESS(200, "Success"),
    CREATE(201, "Create"),
    FOUND(302, "Found"),
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not found"),
    METHOD_NOT_ALLOW(405, "Method not allow"),
    TIME_OUT(408, "Time out"),
    INTERNAL_SERVER_ERROR(500, "Internal service error"),
    SERVICE_UNAVAILABLE(503, "Service unavailable");

    private final Integer status;
    private final String message;

    StatusAndMessageEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
