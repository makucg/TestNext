package es.nextdigital.demo.application.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawalRequestDTO {
    @NotBlank(message = "Card number is mandatory")
    private String cardNumber;
    @NotBlank(message = "Amount is mandatory")
    private BigDecimal amount;
    @NotBlank(message = "Operation bank code is mandatory")
    private String operationBankCode;
}

