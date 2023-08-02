package es.nextdigital.demo.application.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardActivationRequestDTO {
    private String cardNumber;
}

