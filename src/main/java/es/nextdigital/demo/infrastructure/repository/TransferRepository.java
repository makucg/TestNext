package es.nextdigital.demo.infrastructure.repository;

import es.nextdigital.demo.domain.model.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
    List<TransferEntity> findBySourceAccount_AccountNumber(String accountNumber);

    List<TransferEntity> findByDestinationAccount_AccountNumber(String accountNumber);
}
