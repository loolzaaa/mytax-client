package ru.loolzaaa.nalog.mytax.client.pojo;

/**
 * Объект, представляющий оказанную услугу.
 * <p>
 * Внимание!
 * Стоимость указывается за 1 услугу.
 *
 * @param name     имя услуги
 * @param quantity количество
 * @param amount   стоимость
 */

public record Service(String name, int quantity, double amount) {
}
