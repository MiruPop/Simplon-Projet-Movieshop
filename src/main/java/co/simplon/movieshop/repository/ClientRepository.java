package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findById(Long id);
//    Client findFirstByCommandes(Long idCommande);
}
