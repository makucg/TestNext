package es.nextdigital.demo.infrastructure.mapper;

import es.nextdigital.demo.application.model.Bank;
import es.nextdigital.demo.domain.model.BankEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BankMapper {

    BankMapper INSTANCE = Mappers.getMapper(BankMapper.class);

    Bank toEntity(BankEntity bank);

    BankEntity to(Bank bank);

    List<Bank> toList(List<BankEntity> bankEntities);

    List<BankEntity> toEntityList(List<Bank> banks);
}
