package ru.loolzaaa.nalog.mytax.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс передачи данных аутентификации пользователя.
 * <p>
 * Содержит данные об основном токене, токене
 * обновления основного токена, времени их экспирации,
 * а также различные данные о пользователе.
 * <p>
 * Получается во время аутентификации пользователя,
 * для внутреннего использования.
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationDTO {

    private String refreshToken;
    private String refreshTokenExpiresIn;
    private String token;
    private String tokenExpireIn;
    private Profile profile;

    /**
     * Класс, содержащий различные данные о пользователе.
     * <p>
     * Наполнение класса может изменяться, не все поля
     * могут быть инициализированы при получении.
     * <p>
     * Может быть получен после инициализации клиента.
     */

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Profile {
        private String lastName;
        private Long id;
        private String displayName;
        private String middleName;
        private String email;
        private String phone;
        private String inn;
        private String snils;
        private Boolean avatarExists;
        private String initialRegistrationDate;
        private String registrationDate;
        private String firstReceiptRegisterTime;
        private String firstReceiptCancelTime;
        private Boolean hideCancelledReceipt;
        private String registerAvailable;
        private String status;
        private Boolean restrictedMode;
        private String pfrUrl;
        private String login;
    }
}
