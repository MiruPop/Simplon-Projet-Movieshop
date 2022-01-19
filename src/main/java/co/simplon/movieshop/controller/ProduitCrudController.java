package co.simplon.movieshop.controller;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieshop/admin/stock")
public class ProduitCrudController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/all")
    public ResponseEntity<List<Produit>> listerProduits() {
        List<Produit> liste = produitService.getAllProduits();

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Produit trouverUnProduit(@PathVariable("id") String id) {
        return produitService.selectProduitParId(Long.parseLong(id));
    }

    @PostMapping("/add")
    public ResponseEntity<String> ajouterProduit(@RequestBody Produit produit) {
        try {
            produitService.addProduit(produit);
            return new ResponseEntity<>("Nouveau produit ajouté", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("pas ajouté");
        }

        return new ResponseEntity<>("ERREUR: impossible d'ajouter un nouveau produit", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<String> modifierProduit(@RequestBody Produit produit) {
        try {
            produitService.updateProduit(produit);
            return new ResponseEntity<>("Informations produit modifiées", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas modifié");
        }

        return new ResponseEntity<>("ERREUR: impossible de modifier le produit", HttpStatus.BAD_REQUEST);
    }
}
