package es.nextdigital.demo.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    private Long id;
    private String name;
    private String code;
    private String address;
    private Instant createdAt;
    private Instant updatedAt;
}
