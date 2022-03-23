package co.simplon.movieshop.controller.user;

import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = {"/movieshop", "/movieshop/home"})
public class FrontController {

    @Autowired
    private ProduitService produitService;

    @GetMapping("")
    public ResponseEntity<List<Produit>> listerProduits() {
        List<Produit> liste = produitService.getAllProduits();

        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
}
