package es.nextdigital.demo.domain.exception;

public class AccountNotFoundException extends BusinessException {

    public AccountNotFoundException() {
        super("Account not found");
    }
}
