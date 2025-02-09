package ru.loolzaaa.nalog.mytax.client.exception;

import lombok.Getter;

@Getter
public class ApiRequestException extends RuntimeException {

    private final int statusCode;
    private final Object body;

    public ApiRequestException(String message, int statusCode, Object body) {
        super(String.format("Api request error: %s. Status code: %d. Body %s", message, statusCode, body));
        this.statusCode = statusCode;
        this.body = body;
    }

    public ApiRequestException(int statusCode, Object body) {
        this(null, statusCode, body);
    }
}
