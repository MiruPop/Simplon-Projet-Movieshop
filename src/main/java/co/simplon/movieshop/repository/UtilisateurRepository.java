package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
}
