package es.nextdigital.demo.application.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePinRequestDTO {
    private String cardNumber;
    private String currentPin;
    private String newPin;
}

