package es.nextdigital.demo.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private Long id;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal commission;
    private Instant transactionDate;
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private Instant createdAt;
    private Instant updatedAt;
}