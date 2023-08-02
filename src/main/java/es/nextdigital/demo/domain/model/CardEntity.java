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
@Table(name = "card")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CardEntity extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "card_number")
    private String cardNumber;

    @Column(nullable = false, name = "card_type")
    private CardType cardType;

    @Column(nullable = false, name = "credit_limit")
    private BigDecimal creditLimit;

    @Column(nullable = false, name = "available_credit")
    private BigDecimal availableCredit;

    @Column(nullable = false)
    private boolean activated;

    @Column(nullable = false)
    private String pin;

    @Column(nullable = false, name = "withdrawal_limit")
    private BigDecimal withdrawalLimit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;
}
