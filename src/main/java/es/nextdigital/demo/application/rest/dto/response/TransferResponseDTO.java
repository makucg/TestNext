package es.nextdigital.demo.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferResponseDTO {
    private Long id;
    private String transactionType;
    private BigDecimal amount;
    private Instant transactionDate;
    private BigDecimal sourceCardBalance;
    private BigDecimal destinationCardBalance;
    private Instant createdAt;
    private Instant updatedAt;
}