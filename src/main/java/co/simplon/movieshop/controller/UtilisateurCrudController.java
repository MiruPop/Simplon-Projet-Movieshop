package co.simplon.movieshop.controller;

import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.service.UtilisateurAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieshop/admin/user")
public class UtilisateurCrudController {

    @Qualifier("utilisateurAddService")
    @Autowired
    UtilisateurAddService userService;

    @PostMapping("/add")
    public ResponseEntity<String> ajouterClient(@RequestBody Utilisateur utilisateur) {
        try {
            userService.addUser(utilisateur);
            return new ResponseEntity<>("Nouvel utilisateur ajouté", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("pas ajouté");
        }

        return new ResponseEntity<>("ERREUR: impossible d'ajouter le nouvel utilisateur", HttpStatus.BAD_REQUEST);
    }
}
