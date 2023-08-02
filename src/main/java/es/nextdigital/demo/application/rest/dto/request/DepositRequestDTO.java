package es.nextdigital.demo.application.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequestDTO {
    private String cardNumber;
    private BigDecimal amount;
    private String operationBankCode;
}

