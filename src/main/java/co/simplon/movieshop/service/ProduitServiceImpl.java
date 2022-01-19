package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public void achatProduit(Produit produit, int quantiteAchetée) {
        int quantiteStock = produit.getQuantiteStock();
        if(quantiteStock >= quantiteAchetée) {
            produit.setQuantiteStock(quantiteStock - quantiteAchetée);
        }
        else {
            System.out.println("quantité insuffisante");
        }
    }

    // cette fonctionnalité n'est pas accesible pour le statut "ADMIN"
    // à utiliser lors d'un futur développement, par un "SUPER_USER", par exemple
//    @Override
//    public void deleteProduit(Produit produit) {
//        produitRepository.delete(produit);
//    }
}
