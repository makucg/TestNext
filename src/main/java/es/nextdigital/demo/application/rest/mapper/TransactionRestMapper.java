package es.nextdigital.demo.application.rest.mapper;

import es.nextdigital.demo.application.model.Transaction;
import es.nextdigital.demo.application.rest.dto.response.TransactionResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionRestMapper {

    TransactionRestMapper INSTANCE = Mappers.getMapper(TransactionRestMapper.class);

    TransactionResponseDTO toTransactionResponseDTO(Transaction transaction);

    List<TransactionResponseDTO> toTransactionResponseDTOList(List<Transaction> transactions);

}
