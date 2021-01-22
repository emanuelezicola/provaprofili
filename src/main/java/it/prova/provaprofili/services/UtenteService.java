package it.prova.provaprofili.services;

import it.prova.provaprofili.models.Utente;

import java.util.List;

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
