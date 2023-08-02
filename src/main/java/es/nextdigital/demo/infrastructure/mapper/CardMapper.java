package es.nextdigital.demo.infrastructure.mapper;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.domain.model.CardEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card to(CardEntity cardEntity);

    CardEntity toEntity(Card card);

    List<Card> toList(List<CardEntity> cardEntities);

    List<CardEntity> toEntityList(List<Card> cards);
}
