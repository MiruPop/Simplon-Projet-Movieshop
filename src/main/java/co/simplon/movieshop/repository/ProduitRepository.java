package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository  extends JpaRepository<Produit, Long> {
}