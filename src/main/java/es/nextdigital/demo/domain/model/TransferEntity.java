package es.nextdigital.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "transfer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String reference;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "source_account_id", nullable = false)
    private AccountEntity sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id", nullable = false)
    private AccountEntity destinationAccount;

    @Column(nullable = false, name = "transfer_date")
    private Instant transferDate;
}
