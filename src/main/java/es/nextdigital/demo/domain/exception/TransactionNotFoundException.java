package es.nextdigital.demo.domain.exception;

public class TransactionNotFoundException extends BusinessException {

    public TransactionNotFoundException() {
        super("Transaction not found");
    }
}
