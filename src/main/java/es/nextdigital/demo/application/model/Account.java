package es.nextdigital.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Bank bank;
    private Instant createdAt;
    private Instant updatedAt;
}
