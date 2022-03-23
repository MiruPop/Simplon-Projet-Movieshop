package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
    Optional<Commande> findByNrCommande(Long id);
//    Optional<Commande> findByNrCommande(Long nrCommande);
    List<Commande> findByClient(Client client);
}
