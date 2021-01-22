package it.prova.provaprofili.repositories;

import it.prova.provaprofili.models.Utente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByEmailAndPassword(String email, String password);

    List<Utente> findAll(Specification<Utente> userModelSpecification);
}
