package es.nextdigital.demo.application.rest.mapper;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.application.rest.dto.response.CardResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardRestMapper {

    CardRestMapper INSTANCE = Mappers.getMapper(CardRestMapper.class);

    CardResponseDTO toCardResponseDTO(Card card);

    Card toCard(CardResponseDTO cardResponseDTO);

    List<CardResponseDTO> toCardResponseDTOList(List<Card> cards);

    List<Card> toCardList(List<CardResponseDTO> cardResponseDTOs);

}
