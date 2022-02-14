package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.CommandeProduit;
import co.simplon.movieshop.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);
//    Optional<Produit> findByCommandes(Long idCommande);
    List<Produit> findProduitsByCommandeProduitsIn(List<CommandeProduit> commandeProduits);
    List<Produit> findAllByCommandeProduits(CommandeProduit commandeProduit);
}
