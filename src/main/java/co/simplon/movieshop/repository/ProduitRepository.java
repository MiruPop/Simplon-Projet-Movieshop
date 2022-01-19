package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit, Long> {
    Optional<Produit> findById(Long id);
}
