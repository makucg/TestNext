package es.nextdigital.demo.application.rest.mapper;

import es.nextdigital.demo.application.model.Account;
import es.nextdigital.demo.application.rest.dto.response.AccountResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountRestMapper {

    AccountRestMapper INSTANCE = Mappers.getMapper(AccountRestMapper.class);

    AccountResponseDTO toAccountResponseDTO(Account account);

}
