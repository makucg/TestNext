package es.nextdigital.demo.infrastructure.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PinEncoder {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encodePin(String pin) {
        return encoder.encode(pin);
    }

    public static boolean matches(String rawPin, String encodedPin) {
        return encoder.matches(rawPin, encodedPin);
    }
}
