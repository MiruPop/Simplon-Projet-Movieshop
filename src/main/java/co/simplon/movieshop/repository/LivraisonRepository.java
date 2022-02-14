package co.simplon.movieshop.repository;

import co.simplon.movieshop.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Integer> {
    Livraison findByCommandes(Long idCommande);
}
