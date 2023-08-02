package es.nextdigital.demo.application.rest.controller;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.application.rest.dto.response.AccountResponseDTO;
import es.nextdigital.demo.application.rest.dto.response.TransactionResponseDTO;
import es.nextdigital.demo.application.rest.mapper.AccountRestMapper;
import es.nextdigital.demo.application.rest.mapper.TransactionRestMapper;
import es.nextdigital.demo.application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountRestMapper accountRestMapper = AccountRestMapper.INSTANCE;
    private final TransactionRestMapper transactionRestMapper = TransactionRestMapper.INSTANCE;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByNumber(accountNumber);
        return ResponseEntity.ok(accountRestMapper.toAccountResponseDTO(account));
    }

    @GetMapping("/{accountNumber}/balance")
    public ResponseEntity<String> getAccountBalance(@PathVariable String accountNumber) {
        BigDecimal balance = accountService.getAccountBalance(accountNumber);
        return ResponseEntity.ok(balance.toString());
    }

    @GetMapping("/{accountNumber}/transactions")
    public ResponseEntity<List<TransactionResponseDTO>> getAccountTransactions(@PathVariable String accountNumber) {
        List<Transaction> transactions = accountService.getAccountTransactions(accountNumber);
        return ResponseEntity.ok(transactionRestMapper.toTransactionResponseDTOList(transactions));
    }
}
