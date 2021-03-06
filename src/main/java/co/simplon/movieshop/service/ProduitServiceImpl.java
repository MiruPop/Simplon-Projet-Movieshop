package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

     /****************************************************************\
      * A REVOIR les services et routes des produits pour            *
      * permettre l'echange sécurisé d'informations                  *
     \****************************************************************/
    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit selectProduitParId(Long id) {
        Optional<Produit> produitOptionnel = produitRepository.findById(id);
        return produitOptionnel.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'id " + id));
    }

    @Override
    public void addProduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public void updateProduit(Produit produit) {
        produitRepository.save(produit);
    }

    // cette fonctionnalité sera utilisée pour le status "Client"
    // lors du développement des fonctionnalités d'achat

    // créer un Listener sur le DELETE qui va déclencher un trigger côté sql
    //étudier le @PostUpdate
        @Override
    public void selectProduitQuantite(Produit produit, int quantiteSouhaitee) {
        int quantiteStock = produit.getQuantiteStock();
        if(quantiteStock >= quantiteSouhaitee) {
            produit.setQuantiteStock(quantiteStock - quantiteSouhaitee);
        }
        else {
            // je peux lui imposer une quantité max: sélection quantité depuis liste
            // maj avec le stock
            System.out.println("quantité insuffisante");
        }
    }

    public List<Produit> selectionnerProduits(Produit produit, int quantite) {
        List<Produit> produitList = new ArrayList<>();

        return null;
    }

    // cette fonctionnalité n'est pas accesible pour le statut "ADMIN"
    // à utiliser lors d'un futur développement, par un "SUPER_USER", par exemple
//    @Override
//    public void deleteProduit(Produit produit) {
//        produitRepository.delete(produit);
//    }
}
