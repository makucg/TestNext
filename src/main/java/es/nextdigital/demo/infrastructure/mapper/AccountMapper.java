package es.nextdigital.demo.infrastructure.mapper;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.domain.model.AccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account to(AccountEntity accountEntity);

    AccountEntity toEntity(Account account);

    List<Account> toList(List<AccountEntity> accountEntities);

    List<AccountEntity> toEntityList(List<Account> accounts);
}
