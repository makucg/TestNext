package es.nextdigital.demo.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "account_number")
    private String accountNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;
}
