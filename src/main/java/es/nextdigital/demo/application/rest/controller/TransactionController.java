package es.nextdigital.demo.application.rest.controller;

import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.application.rest.dto.request.DepositRequestDTO;
import es.nextdigital.demo.application.rest.dto.request.TransferRequestDTO;
import es.nextdigital.demo.application.rest.dto.request.WithdrawalRequestDTO;
import es.nextdigital.demo.application.rest.dto.response.TransactionResponseDTO;
import es.nextdigital.demo.application.rest.mapper.TransactionRestMapper;
import es.nextdigital.demo.application.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionRestMapper transactionRestMapper = TransactionRestMapper.INSTANCE;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit")
    public ResponseEntity<Void> deposit(@Valid @RequestBody DepositRequestDTO requestDTO) {
        transactionService.deposit(requestDTO.getCardNumber(), requestDTO.getAmount(), requestDTO.getOperationBankCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<Void> withdrawal(@Valid @RequestBody WithdrawalRequestDTO requestDTO) {
        transactionService.withdrawal(requestDTO.getCardNumber(), requestDTO.getAmount(), requestDTO.getOperationBankCode());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferRequestDTO requestDTO) {
        transactionService.transfer(requestDTO.getSourceAccountNumber(), requestDTO.getDestinationAccountNumber(), requestDTO.getAmount(), requestDTO.getReference());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<TransactionResponseDTO> getTransactionById(@PathVariable Long transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ResponseEntity.ok(transactionRestMapper.toTransactionResponseDTO(transaction));
    }
}
