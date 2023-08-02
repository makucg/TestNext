package es.nextdigital.demo.domain.exception;

public class CardNotFoundException extends BusinessException {

    public CardNotFoundException() {
        super("Card not found");
    }
}
