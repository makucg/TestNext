package es.nextdigital.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private Long id;
    private String cardNumber;
    private String cardType;
    private String pin;
    private Account account;
    private BigDecimal creditLimit;
    private BigDecimal availableCredit;
    private boolean activated;
    private Instant createdAt;
    private Instant updatedAt;
}
