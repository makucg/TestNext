package es.nextdigital.demo.domain.ports;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.domain.model.CardType;

import java.math.BigDecimal;

public interface CardPersistancePort {
    Card findByCardNumber(String cardNumber);

    Card findByCardNumberAndCardType(String cardNumber, CardType cardType);

    Card findByAccountId(Long accountId);

    Card save(Card card);

    Card withdraw(String cardNumber, BigDecimal amount, BigDecimal commission);

    Card deposit(String cardNumber, BigDecimal amount, BigDecimal commission);
}
