package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
}
