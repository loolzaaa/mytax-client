package ru.loolzaaa.nalog.mytax.client.exception;

import lombok.Getter;

/**
 * Исключение клиента, связанное с результатом запроса.
 * <p>
 * Выбрасывается в тех случаях, когда код ответа
 * от API не равен 200.
 */

@Getter
public class ApiRequestException extends ApiException {

    private final int statusCode;
    private final transient Object body;

    /**
     * Создание исключения, связанного с кодом ответа от API.
     *
     * @param message    сообщение об ошибке
     * @param statusCode статус ответа
     * @param body       тело ответа
     */
    public ApiRequestException(String message, int statusCode, Object body) {
        super(String.format("Api request error: %s. Status code: %d. Body %s", message, statusCode, body));
        this.statusCode = statusCode;
        this.body = body;
    }
}
