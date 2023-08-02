package es.nextdigital.demo.application.service;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.application.model.TransactionType;
import es.nextdigital.demo.infrastructure.adapter.AccountRepositoryAdapter;
import es.nextdigital.demo.infrastructure.adapter.CardRepositoryAdapter;
import es.nextdigital.demo.infrastructure.adapter.TransactionRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class TransactionService {
    private final TransactionRepositoryAdapter transactionRepository;
    private final CardRepositoryAdapter cardRepository;
    private final AccountRepositoryAdapter accountRepository;
    private final TransferService transferService;

    @Autowired
    public TransactionService(TransactionRepositoryAdapter transactionRepository, CardRepositoryAdapter cardRepository, AccountRepositoryAdapter accountRepository, TransferService transferService) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.transferService = transferService;
    }

    // add deposit, withdraw, transfer methods
    public Transaction deposit(String cardNumber, BigDecimal amount, String bankCode) {
        Card card = cardRepository.findByCardNumber(cardNumber);

        BigDecimal commission = BigDecimal.ZERO;
        if (!card.getAccount().getBank().getCode().equals(bankCode)) {
            commission = amount.multiply(new BigDecimal("0.005"));
        }

        cardRepository.deposit(card.getCardNumber(), amount, commission);

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEPOSIT.name());
        transaction.setAmount(amount);
        transaction.setCommission(commission);
        transaction.setTransactionDate(Instant.now());
        transaction.setAccount(card.getAccount());

        return transactionRepository.save(transaction);
    }

    public Transaction withdrawal(String cardNumber, BigDecimal amount, String bankCode) {
        Card card = cardRepository.findByCardNumber(cardNumber);

        BigDecimal commission = BigDecimal.ZERO;
        if (!card.getAccount().getBank().getCode().equals(bankCode)) {
            commission = amount.multiply(new BigDecimal("0.005"));
        }

        cardRepository.withdraw(card.getCardNumber(), amount, commission);

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.WITHDRAWAL.name());
        transaction.setAmount(amount);
        transaction.setCommission(commission);
        transaction.setTransactionDate(Instant.now());
        transaction.setAccount(card.getAccount());

        return transactionRepository.save(transaction);
    }

    public void transfer(String sourceAccountNumber, String destinationAccountNumber, BigDecimal amount, String reference) {
        Account sourceAccount = accountRepository.findByAccountNumber(sourceAccountNumber);
        Account destinationAccount = accountRepository.findByAccountNumber(destinationAccountNumber);
        accountRepository.transfer(sourceAccount, destinationAccount, amount);

        Transaction sourceTransaction = new Transaction();
        sourceTransaction.setTransactionType(TransactionType.OUTGOING_TRANSFER.name());
        sourceTransaction.setAmount(amount);
        sourceTransaction.setAccount(sourceAccount);

        Transaction destinationTransaction = new Transaction();
        destinationTransaction.setTransactionType(TransactionType.INCOMING_TRANSFER.name());
        destinationTransaction.setAmount(amount);
        destinationTransaction.setAccount(destinationAccount);

        transactionRepository.save(sourceTransaction);
        transactionRepository.save(destinationTransaction);

        transferService.transfer(sourceAccount, destinationAccount, amount, reference);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }
}