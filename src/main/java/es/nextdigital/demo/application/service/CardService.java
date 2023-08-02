package es.nextdigital.demo.application.service;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.domain.exception.UnauthorizedException;
import es.nextdigital.demo.infrastructure.adapter.CardRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    private final CardRepositoryAdapter cardRepository;

    @Autowired
    public CardService(CardRepositoryAdapter cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card activateCard(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        card.setActivated(true);
        return cardRepository.save(card);
    }

    public Card changePin(String cardNumber, String currentPin, String newPin) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        //validate current pin
        if (!card.getPin().equals(currentPin)) {
            throw new UnauthorizedException();
        }
        card.setPin(newPin);
        return cardRepository.save(card);
    }

    public Card getCardByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }
}