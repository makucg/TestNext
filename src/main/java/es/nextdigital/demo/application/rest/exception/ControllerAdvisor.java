package es.nextdigital.demo.application.rest.exception;

import es.nextdigital.demo.application.rest.response.ErrorResponse;
import es.nextdigital.demo.domain.exception.AccountNotFoundException;
import es.nextdigital.demo.domain.exception.CardNotFoundException;
import es.nextdigital.demo.domain.exception.TransactionNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleBadRequest(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleDataNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = HttpClientErrorException.Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseEntity<String> handleUnauthorizedAccess(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .cause(ex.getMessage())
                .details(request.getDescription(false))
                .timestamp(Instant.now())
                .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(
            AccountNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .cause(ex.getMessage())
                .details(request.getDescription(false))
                .timestamp(Instant.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleCardNotFoundException(
            CardNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .cause(ex.getMessage())
                .details(request.getDescription(false))
                .timestamp(Instant.now())
                .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TransactionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleTransactionNotFoundException(
            TransactionNotFoundException ex, WebRequest request) {

        return new ResponseEntity<>(ErrorResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .cause(ex.getMessage())
                .details(request.getDescription(false))
                .timestamp(Instant.now())
                .build(), HttpStatus.NOT_FOUND);
    }

}