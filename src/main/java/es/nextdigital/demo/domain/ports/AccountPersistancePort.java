package es.nextdigital.demo.domain.ports;

import es.nextdigital.demo.application.model.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountPersistancePort {
    Account findByAccountNumber(String accountNumber);

    Account findById(Long id);

    List<Account> findAll();

    Account save(Account account);

    void delete(Account account);

    void transfer(Account sourceAccount, Account destinationAccount, BigDecimal amount);
}
