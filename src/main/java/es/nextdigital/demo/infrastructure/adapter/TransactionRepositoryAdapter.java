package es.nextdigital.demo.infrastructure.adapter;

import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.domain.exception.TransactionNotFoundException;
import es.nextdigital.demo.domain.model.TransactionEntity;
import es.nextdigital.demo.domain.ports.TransactionPersistancePort;
import es.nextdigital.demo.infrastructure.mapper.TransactionMapper;
import es.nextdigital.demo.infrastructure.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionRepositoryAdapter implements TransactionPersistancePort {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper = TransactionMapper.INSTANCE;

    @Autowired
    public TransactionRepositoryAdapter(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findByAccount(String accountNumber) {
        List<TransactionEntity> transactionEntities = transactionRepository.findByAccount_AccountNumber(accountNumber);
        return transactionEntities.stream()
                .map(transactionMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public Transaction save(Transaction transaction) {
        TransactionEntity transactionEntity = transactionMapper.toEntity(transaction);
        TransactionEntity savedTransactionEntity = transactionRepository.save(transactionEntity);
        return transactionMapper.to(savedTransactionEntity);
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
                .map(transactionMapper::to)
                .orElseThrow(TransactionNotFoundException::new);
    }
}
