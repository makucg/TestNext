package es.nextdigital.demo.infrastructure.adapter;

import es.nextdigital.demo.application.model.Transfer;
import es.nextdigital.demo.domain.model.TransferEntity;
import es.nextdigital.demo.domain.ports.TransferPersistancePort;
import es.nextdigital.demo.infrastructure.mapper.TransferMapper;
import es.nextdigital.demo.infrastructure.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferRepositoryAdapter implements TransferPersistancePort {
    private final TransferRepository transferRepository;
    private final TransferMapper transferMapper = TransferMapper.INSTANCE;

    @Autowired
    public TransferRepositoryAdapter(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    @Override
    public Transfer createTransfer(Transfer transfer) {
        TransferEntity transferEntity = transferMapper.toEntity(transfer);
        TransferEntity savedEntity = transferRepository.save(transferEntity);
        return transferMapper.to(savedEntity);
    }

    @Override
    public Transfer findById(Long transferId) {
        return transferRepository.findById(transferId)
                .map(transferMapper::to)
                .orElse(null);
    }

    @Override
    public List<Transfer> findBySourceAccountNumber(String cardNumber) {
        List<TransferEntity> transferEntities = transferRepository.findBySourceAccount_AccountNumber(cardNumber);
        return transferEntities.stream()
                .map(transferMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transfer> findByAccountCardNumber(String cardNumber) {
        List<TransferEntity> transferEntities = transferRepository.findByDestinationAccount_AccountNumber(cardNumber);
        return transferEntities.stream()
                .map(transferMapper::to)
                .collect(Collectors.toList());
    }

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity transferEntity = transferMapper.toEntity(transfer);
        TransferEntity savedTransfer = transferRepository.save(transferEntity);
        return transferMapper.to(savedTransfer);
    }
}
