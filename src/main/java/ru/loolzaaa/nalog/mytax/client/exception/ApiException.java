package ru.loolzaaa.nalog.mytax.client.exception;

/**
 * Основное исключение клиента.
 * <p>
 * Будет выброшено при любых ошибках использования
 * API, которые не связаны в результатов запроса.
 */

public class ApiException extends RuntimeException {
    /**
     * Создание основного исключения.
     *
     * @param message сообщение об ошибке
     */
    public ApiException(String message) {
        super(message);
    }
}
