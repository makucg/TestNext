package es.nextdigital.demo.application.rest.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class ErrorResponse {

    private int code;

    private String cause;

    private String details;

    private Instant timestamp;
}
