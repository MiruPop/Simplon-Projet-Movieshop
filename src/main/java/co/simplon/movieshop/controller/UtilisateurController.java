package co.simplon.movieshop.controller;

import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("secure.movieshop.com/account")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

 /****************************************************************\
  * A REVOIR les services et routes de l'Utilisateur pour        *
  * permettre l'echange sécurisé d'informations                  *
 \****************************************************************/

    @PostMapping("/server/gateway/signup")
    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.addUser(utilisateur);
            return new ResponseEntity<>("Nouvel utilisateur ajouté", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("pas ajouté");
        }

        return new ResponseEntity<>("ERREUR: impossible d'ajouter le nouvel utilisateur", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/server/gateway/signin")
    public Utilisateur trouverUtilisateurParEmail(@RequestBody String email) {
        return utilisateurService.findUserByEmail(email);
    }

    @PutMapping("/dashboard/update")
    public ResponseEntity<String> modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.update(utilisateur);
            return new ResponseEntity<>("Informations utilisateur modifiées", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas modifié");
        }
        return new ResponseEntity<>("ERREUR: impossible de modifier l'utilisateur", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/dashboard/delete")
    public ResponseEntity<String> deleteUserAccount(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.delete(utilisateur);
            return new ResponseEntity<>("Compte supprimé", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas supprimé");
        }
        return new ResponseEntity<>("ERREUR: impossible de supprimer l'utilisateur", HttpStatus.BAD_REQUEST);
    }
}
