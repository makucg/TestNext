package es.nextdigital.demo.application.service;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.application.model.Transfer;
import es.nextdigital.demo.infrastructure.adapter.CardRepositoryAdapter;
import es.nextdigital.demo.infrastructure.adapter.TransferRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;

@Service
public class TransferService {
    private final TransferRepositoryAdapter transferRepository;
    private final CardRepositoryAdapter cardRepository;

    @Autowired
    public TransferService(TransferRepositoryAdapter transferRepository, CardRepositoryAdapter cardRepository) {
        this.transferRepository = transferRepository;
        this.cardRepository = cardRepository;
    }

    public Transfer transfer(Account sourceAccount, Account destinationAccount, BigDecimal amount, String reference) {
        /*Card sourceCard = cardRepository.findByCardNumber(sourceCardNumber);
        Card destinationCard = cardRepository.findByCardNumber(destinationCardNumber);

        BigDecimal sourceCardBalance = sourceCard.getAvailableCredit();

        if (sourceCardBalance.compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient funds in the source card");
        }

        BigDecimal newSourceCardBalance = sourceCardBalance.subtract(amount);
        sourceCard.setAvailableCredit(newSourceCardBalance);

        BigDecimal destinationCardBalance = destinationCard.getAvailableCredit();
        BigDecimal newDestinationCardBalance = destinationCardBalance.add(amount);
        destinationCard.setAvailableCredit(newDestinationCardBalance);*/

        Transfer transfer = new Transfer();
        transfer.setSourceAccount(sourceAccount);
        transfer.setDestinationAccount(destinationAccount);
        transfer.setAmount(amount);
        transfer.setTransferDate(Instant.now());
        transfer.setReference(reference);

        return transferRepository.save(transfer);
    }
}