package it.prova.provaprofili.services.servicesimpl;

import it.prova.provaprofili.models.Utente;
import it.prova.provaprofili.repositories.UtenteRepository;
import it.prova.provaprofili.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UtenteServiceImpl implements UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteServiceImpl(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    @Override
    public Utente crea(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public Utente findById(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Utente> findBy(Utente utente) {
        return utenteRepository.findAll((root, criteriaQuery, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();


            if (!Objects.isNull(utente.getNome())) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("nome")),
                        "%" + utente.getNome().toUpperCase() + "%"));
            }


            if (!Objects.isNull(utente.getCognome())) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.upper(root.get("cognome")),
                        "%" + utente.getCognome().toUpperCase() +"%"));
            }


            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    @Override
    public Utente aggiorna(Utente utente) {
        return utenteRepository.save(utente);
    }

    @Override
    public void cancella(Utente utente) {
        utenteRepository.delete(utente);
    }

    @Override
    public void cancellaById(Long id) {
        utenteRepository.deleteById(id);
    }
}
