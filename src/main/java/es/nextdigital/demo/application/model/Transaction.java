package es.nextdigital.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private String transactionType;
    private BigDecimal amount;
    private BigDecimal commission;
    private Account account;
    private Instant transactionDate;
    private Instant createdAt;
    private Instant updatedAt;
}
