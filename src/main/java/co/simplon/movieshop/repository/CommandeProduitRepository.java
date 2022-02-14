package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.CommandeProduit;
import co.simplon.movieshop.model.CommandeProduitKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, CommandeProduitKey> {
    List<CommandeProduit> findAllById_IdCommande(Long idCommande);
    CommandeProduit findFirstById_IdCommande(Long idCommande);
}
