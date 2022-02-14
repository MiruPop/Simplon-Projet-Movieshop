package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
    Optional<Commande> findById(Long id);
    List<Commande> findByClient(Long idClient);
//    Commande findFirstByCommandeProduits(Long idCommande);
}
