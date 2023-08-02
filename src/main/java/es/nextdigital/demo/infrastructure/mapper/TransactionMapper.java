package es.nextdigital.demo.infrastructure.mapper;

import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.domain.model.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction to(TransactionEntity transactionEntity);

    TransactionEntity toEntity(Transaction transaction);

    List<Transaction> toList(List<TransactionEntity> transactionEntities);

    List<TransactionEntity> toEntityList(List<Transaction> transactions);
}
