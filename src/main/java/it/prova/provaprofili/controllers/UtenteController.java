package it.prova.provaprofili.controllers;

import it.prova.provaprofili.dto.CommonUserDto;
import it.prova.provaprofili.dto.UtenteRegistrazioneDto;
import it.prova.provaprofili.models.Utente;
import it.prova.provaprofili.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Set;

@RestController
@RequestMapping("/utente")
@CrossOrigin
public class UtenteController {

    private final UtenteService utenteService;
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }


    @PostMapping("/registrazione")
    public ResponseEntity<Object> registrazione(@RequestBody  UtenteRegistrazioneDto utenteDto) {

        //controllo validità dto
        Set<ConstraintViolation<UtenteRegistrazioneDto>> constraintViolations = validator.validate(utenteDto);

        if (!constraintViolations.isEmpty() || !utenteDto.getPassword().equals(utenteDto.getPasswordRepeat())) {
            return ResponseEntity.badRequest().body("Errore durante il salvataggio dei dati. Compilare tutti i campi correttamente");
        }

        Utente utenteDaRegistrare = new Utente(null, utenteDto.getNome(), utenteDto.getCognome(), utenteDto.getEmail(), utenteDto.getPassword(), LocalDate.now());

        utenteService.crea(utenteDaRegistrare);

        return ResponseEntity.ok(new CommonUserDto(utenteDaRegistrare.getId(), utenteDaRegistrare.getNome(), utenteDaRegistrare.getCognome(), utenteDaRegistrare.getEmail(), utenteDaRegistrare.getDataRegistrazione()));
    }

    //TODO altre API

}
