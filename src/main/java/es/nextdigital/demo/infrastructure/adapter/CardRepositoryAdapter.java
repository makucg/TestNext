package es.nextdigital.demo.infrastructure.adapter;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.domain.exception.CardNotFoundException;
import es.nextdigital.demo.domain.exception.UnauthorizedException;
import es.nextdigital.demo.domain.model.CardEntity;
import es.nextdigital.demo.domain.model.CardType;
import es.nextdigital.demo.domain.ports.CardPersistancePort;
import es.nextdigital.demo.infrastructure.mapper.CardMapper;
import es.nextdigital.demo.infrastructure.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CardRepositoryAdapter implements CardPersistancePort {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper = CardMapper.INSTANCE;

    @Autowired
    public CardRepositoryAdapter(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card findByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber).map(cardMapper::to)
                .orElseThrow(CardNotFoundException::new);
    }

    @Override
    public Card findByCardNumberAndCardType(String cardNumber, CardType cardType) {
        return cardRepository.findByCardNumberAndCardType(cardNumber, cardType).map(cardMapper::to)
                .orElseThrow(CardNotFoundException::new);
    }

    @Override
    public Card findByAccountId(Long accountId) {
        return cardRepository.findByAccount_Id(accountId).map(cardMapper::to).orElseThrow(CardNotFoundException::new);
    }

    @Override
    public Card save(Card card) {
        CardEntity cardEntity = cardMapper.toEntity(card);
        CardEntity savedCardEntity = cardRepository.save(cardEntity);
        return cardMapper.to(savedCardEntity);
    }

    @Override
    public Card withdraw(String cardNumber, BigDecimal amount, BigDecimal commission) {
        CardEntity cardEntity = cardRepository.findByCardNumber(cardNumber).orElseThrow(CardNotFoundException::new);
        if (cardEntity.getWithdrawalLimit().compareTo(amount) < 0) {
            throw new UnauthorizedException();
        }

        final BigDecimal amountWithCommission = amount.subtract(commission.multiply(amount));
        switch (cardEntity.getCardType()) {
            case DEBIT -> {
                if (cardEntity.getAccount().getBalance().compareTo(amount) < 0) {
                    throw new UnauthorizedException();
                } else {
                    cardEntity.getAccount().setBalance(cardEntity.getAccount().getBalance().subtract(amountWithCommission));
                }
            }
            case CREDIT -> {
                if (cardEntity.getAvailableCredit().compareTo(amount) < 0) {
                    throw new UnauthorizedException();
                } else {
                    cardEntity.setAvailableCredit(cardEntity.getAvailableCredit().subtract(amountWithCommission));
                }
            }
        }
        CardEntity savedCardEntity = cardRepository.save(cardEntity);
        return cardMapper.to(savedCardEntity);
    }

    @Override
    public Card deposit(String cardNumber, BigDecimal amount, BigDecimal commission) {
        CardEntity cardEntity = cardRepository.findByCardNumber(cardNumber).orElseThrow(CardNotFoundException::new);

        final BigDecimal amountWithCommission = amount.subtract(commission.multiply(amount));
        switch (cardEntity.getCardType()) {
            case DEBIT -> cardEntity.getAccount().setBalance(cardEntity.getAccount().getBalance().add(amountWithCommission));
            case CREDIT -> cardEntity.setAvailableCredit(cardEntity.getAvailableCredit().add(amountWithCommission));
        }
        CardEntity savedCardEntity = cardRepository.save(cardEntity);
        return cardMapper.to(savedCardEntity);
    }
}
