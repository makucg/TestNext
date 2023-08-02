package es.nextdigital.demo.domain.ports;

import es.nextdigital.demo.application.model.Transfer;

import java.util.List;

public interface TransferPersistancePort {

    Transfer createTransfer(Transfer transfer);

    Transfer findById(Long transferId);

    List<Transfer> findBySourceAccountNumber(String accountNumber);

    List<Transfer> findByAccountCardNumber(String accountNumber);

    Transfer save(Transfer transfer);
}
