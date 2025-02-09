package ru.loolzaaa.nalog.mytax.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс передачи данных с результатами обновления
 * основного токена.
 * <p>
 * Содержит данные о новом основном токене, токене
 * для обновления основного токена, а также даты
 * их экспирации.
 * <p>
 * Получается во время обновления основного токена,
 * для внутреннего использования.
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RefreshTokenDTO {
    private String refreshToken;
    private String refreshTokenExpiresIn;
    private String token;
    private String tokenExpireIn;
}
