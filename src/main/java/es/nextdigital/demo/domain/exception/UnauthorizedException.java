package es.nextdigital.demo.domain.exception;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException() {
        super("Unauthorized");
    }
}
