package es.nextdigital.demo.application.rest.controller;

import es.nextdigital.demo.application.model.Card;
import es.nextdigital.demo.application.rest.dto.request.CardActivationRequestDTO;
import es.nextdigital.demo.application.rest.dto.request.ChangePinRequestDTO;
import es.nextdigital.demo.application.rest.dto.response.CardResponseDTO;
import es.nextdigital.demo.application.rest.mapper.CardRestMapper;
import es.nextdigital.demo.application.service.CardService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;
    private final CardRestMapper cardRestMapper = Mappers.getMapper(CardRestMapper.class);

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/activate")
    public ResponseEntity<Void> activateCard(@RequestBody CardActivationRequestDTO requestDTO) {
        cardService.activateCard(requestDTO.getCardNumber());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/change-pin")
    public ResponseEntity<Void> changePin(@RequestBody ChangePinRequestDTO requestDTO) {
        cardService.changePin(requestDTO.getCardNumber(), requestDTO.getCurrentPin(), requestDTO.getNewPin());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{cardNumber}")
    public ResponseEntity<CardResponseDTO> getCardByNumber(@PathVariable String cardNumber) {
        Card card = cardService.getCardByNumber(cardNumber);
        return ResponseEntity.ok(cardRestMapper.toCardResponseDTO(card));
    }
}
