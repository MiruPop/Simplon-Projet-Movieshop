package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Livraison;

public interface LivraisonService {
    Livraison getTypeLivrParIdCommande(Long idCommande);
}
