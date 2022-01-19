package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Produit;

import java.util.List;

public interface ProduitService {
    List<Produit> getAllProduits();

    Produit selectProduitParId(Long id);

    void addProduit(Produit produit);

    void updateProduit(Produit produit);

    void deleteProduit(Produit produit);

}
