package es.nextdigital.demo.infrastructure.mapper;


import es.nextdigital.demo.application.model.Transfer;
import es.nextdigital.demo.domain.model.TransferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransferMapper {

    TransferMapper INSTANCE = Mappers.getMapper(TransferMapper.class);

    Transfer to(TransferEntity transferEntity);

    TransferEntity toEntity(Transfer transfer);

    List<Transfer> toList(List<TransferEntity> transferEntities);

    List<TransferEntity> toEntityList(List<Transfer> transfers);
}
