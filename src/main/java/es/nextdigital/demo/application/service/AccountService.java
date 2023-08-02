package es.nextdigital.demo.application.service;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.infrastructure.adapter.AccountRepositoryAdapter;
import es.nextdigital.demo.infrastructure.adapter.TransactionRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepositoryAdapter accountRepository;
    private final TransactionRepositoryAdapter transactionRepository;

    @Autowired
    public AccountService(AccountRepositoryAdapter accountRepository, TransactionRepositoryAdapter transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public BigDecimal getAccountBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account.getBalance();
    }

    public List<Transaction> getAccountTransactions(String accountNumber) {
        return transactionRepository.findByAccount(accountNumber);
    }
}
