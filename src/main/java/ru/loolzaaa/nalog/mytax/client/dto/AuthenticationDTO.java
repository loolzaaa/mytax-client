package ru.loolzaaa.nalog.mytax.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationDTO {

    private String refreshToken;
    private String refreshTokenExpiresIn;
    private String token;
    private String tokenExpireIn;
    private Profile profile;

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
