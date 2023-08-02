package es.nextdigital.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {
    private Long id;
    private Account sourceAccount;
    private Account destinationAccount;
    private BigDecimal amount;
    private Instant transferDate;
    private String reference;
    private Instant createdAt;
    private Instant updatedAt;
}
