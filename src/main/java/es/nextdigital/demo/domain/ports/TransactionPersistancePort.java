package es.nextdigital.demo.domain.ports;

import es.nextdigital.demo.application.model.Transaction;

import java.util.List;

public interface TransactionPersistancePort {

    List<Transaction> findByAccount(String accountNumber);

    Transaction save(Transaction transaction);

    Transaction findById(Long id);
}
