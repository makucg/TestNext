package es.nextdigital.demo.infrastructure.repository;

import es.nextdigital.demo.domain.model.CardEntity;
import es.nextdigital.demo.domain.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
    Optional<CardEntity> findByCardNumber(String cardNumber);

    Optional<CardEntity> findByCardNumberAndCardType(String cardNumber, CardType cardType);

    Optional<CardEntity> findByAccount_Id(Long accountId);
}
