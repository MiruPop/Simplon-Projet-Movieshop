package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail (String email);
    Utilisateur findByClient(Client client);
}
