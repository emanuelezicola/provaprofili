package it.prova.provaprofili.services;

import it.prova.provaprofili.models.Utente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtenteService {

    //Create
    Utente crea(Utente utente);

    //Read
    Utente findById(Long id);

    List<Utente> findBy(Utente utente);

    //Update
    Utente aggiorna(Utente utente);

    //Delete
    void cancella(Utente utente);

    void cancellaById(Long id);

}
