package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Commande;
import co.simplon.movieshop.model.Produit;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommandeService {
    List<Commande> listerCommandes();
    Commande selectCommandeParId (Long id);
    List<Commande> commandesParClient (Long idClient);
    void passerCommande (Commande commande, List<Produit> listeProd);
    void modifierCommande (Commande commande);
}
