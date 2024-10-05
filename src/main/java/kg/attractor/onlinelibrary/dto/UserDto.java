package kg.attractor.onlinelibrary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class UserDto {
    @NotBlank(message = "Имя не может быть пустым")
    private String name;

    @NotBlank(message = "Фамилия не может быть пустой")
    private String surname;

    private String patronymic;

    @NotBlank(message = "Адрес не может быть пустым")
    private String address;

    @NotBlank(message = "Номер паспорта не может быть пустым")
    private String passportNumber;

    private String password;
    private Long authorityId;
    private String readerCardNumber;
}
