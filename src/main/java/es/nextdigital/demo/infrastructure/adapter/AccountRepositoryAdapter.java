package es.nextdigital.demo.infrastructure.adapter;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.domain.exception.AccountNotFoundException;
import es.nextdigital.demo.domain.exception.UnauthorizedException;
import es.nextdigital.demo.domain.model.AccountEntity;
import es.nextdigital.demo.domain.ports.AccountPersistancePort;
import es.nextdigital.demo.infrastructure.mapper.AccountMapper;
import es.nextdigital.demo.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRepositoryAdapter implements AccountPersistancePort {
    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper = AccountMapper.INSTANCE;

    @Autowired
    public AccountRepositoryAdapter(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).map(accountMapper::to)
                .orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .map(accountMapper::to).orElseThrow(AccountNotFoundException::new);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = accountMapper.toEntity(account);
        return accountMapper.to(accountRepository.save(accountEntity));
    }

    @Override
    public void delete(Account account) {
        AccountEntity accountEntity = accountMapper.toEntity(account);
        accountRepository.delete(accountEntity);
    }

    @Override
    public void transfer(Account sourceAccount, Account destinationAccount, BigDecimal amount) {
        AccountEntity sourceAccountEntity = accountMapper.toEntity(sourceAccount);
        AccountEntity targetAccountEntity = accountMapper.toEntity(destinationAccount);
        if (sourceAccountEntity.getBalance().compareTo(amount) < 0) {
            throw new UnauthorizedException();
        }
        sourceAccountEntity.setBalance(sourceAccount.getBalance().subtract(amount));
        targetAccountEntity.setBalance(destinationAccount.getBalance().add(amount));
        accountRepository.save(sourceAccountEntity);
        accountRepository.save(targetAccountEntity);
    }
}
