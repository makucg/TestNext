package es.nextdigital.demo.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDTO {
    private Long id;
    private String cardNumber;
    private String cardType;
    private BigDecimal creditLimit;
    private BigDecimal availableCredit;
    private boolean activated;
    private Instant createdAt;
    private Instant updatedAt;
}