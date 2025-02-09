package ru.loolzaaa.nalog.mytax.client.pojo;

/**
 * Объект, представляющий квитанцию об успешной отправке чека.
 *
 * @param uuid     идентификатор квитанции
 * @param jsonUrl  ссылка для данные о квитанции в json формате
 * @param printUrl ссылка для получения квитанции для печати
 */

public record Receipt(String uuid, String jsonUrl, String printUrl) {
}
