package es.nextdigital.demo.application.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Instant createdAt;
    private Instant updatedAt;
}