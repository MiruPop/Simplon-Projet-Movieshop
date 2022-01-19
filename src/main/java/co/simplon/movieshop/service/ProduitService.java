package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {
    List<Produit> getAllProduits();

    Produit selectProduitParId(Long id);

    void addProduit(Produit produit);

    void updateProduit(Produit produit);

    void achatProduit(Produit produit, int quantiteSouhaite);

//    void deleteProduit(Produit produit);

}
