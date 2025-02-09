package ru.loolzaaa.nalog.mytax.client.exception;

import lombok.Getter;

@Getter
public class ApiRequestException extends ApiException {

    private final int statusCode;
    private final transient Object body;

    public ApiRequestException(String message, int statusCode, Object body) {
        super(String.format("Api request error: %s. Status code: %d. Body %s", message, statusCode, body));
        this.statusCode = statusCode;
        this.body = body;
    }
}
