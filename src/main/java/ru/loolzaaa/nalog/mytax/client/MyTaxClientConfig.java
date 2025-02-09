package ru.loolzaaa.nalog.mytax.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/**
 * Конфигурация для клиента.
 * <p>
 * Содержит данные по умолчанию для каждого свойства.
 */

@Getter
@Setter
@NoArgsConstructor
public class MyTaxClientConfig {
    @NonNull
    private String prefix = "";
    @NonNull
    private String apiPath = "https://lknpd.nalog.ru/api/v1";
    @NonNull
    private String zoneOffset = "Z";
    @NonNull
    private String refererHeader = "Referer";
}
