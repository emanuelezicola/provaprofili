package it.prova.provaprofili.controllers;

import it.prova.provaprofili.dto.CommonUserDto;
import it.prova.provaprofili.dto.UtenteRegistrazioneDto;
import it.prova.provaprofili.models.Utente;
import it.prova.provaprofili.services.UtenteService;
import it.prova.provaprofili.utils.dtovalidations.DtoValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Objects;

@RestController
@RequestMapping("/utente")
@CrossOrigin
public class UtenteController {

    private final UtenteService utenteService;

    @Autowired

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }


    @PostMapping("/registrazione")
    public ResponseEntity<Object> registrazione(UtenteRegistrazioneDto utenteDto) {

        //controllo validità dto
        //TODO capire se si può fare senza forzare il cast.. inizializzare mappaErrori a Map dà problema con ResponseEntity<Object> in quanto interface
        LinkedHashMap<String, String> mappaErrori = (LinkedHashMap<String, String>) DtoValidations.checkRegistrazione(utenteDto);

        if (!Objects.isNull(mappaErrori)) {
            return ResponseEntity.badRequest().body(mappaErrori);
        }

        Utente utenteDaRegistrare = new Utente(null, utenteDto.getNome(), utenteDto.getCognome(), utenteDto.getEmail(), utenteDto.getPassword(), LocalDate.now());

        utenteService.crea(utenteDaRegistrare);

        //TODO controlli dopo creazione per conversione verso dto

        return ResponseEntity.ok(new CommonUserDto(utenteDaRegistrare.getId(), utenteDaRegistrare.getNome(), utenteDaRegistrare.getCognome(), utenteDaRegistrare.getEmail(), utenteDaRegistrare.getDataRegistrazione()));
    }

    //TODO altre API

}
