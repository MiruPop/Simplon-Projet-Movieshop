package co.simplon.movieshop.service;

import co.simplon.movieshop.model.CommandeProduit;

import java.util.List;

public interface ComProdService {
    List<CommandeProduit> getByIdCommande(Long idCommande);
}
