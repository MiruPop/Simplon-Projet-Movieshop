package co.simplon.movieshop.controller.user;

import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movieshop/log")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

 /****************************************************************\
  * A REVOIR les services et routes de l'Utilisateur pour        *
  * permettre l'echange sécurisé d'informations                  *
 \****************************************************************/

 @GetMapping("/login")
 public Utilisateur trouverUtilisateurParEmail(@RequestBody String email) {
     //ajouter condition égalité "password" inséré / stocké
     //@RequestBody avec 2 params ? (Map<String, String> json
     // ou jackson lib ObjectNode objectNode)
     return utilisateurService.findUserByEmail(email);
 }

 @PostMapping("/signup")
    public ResponseEntity<String> ajouterUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            utilisateurService.addUser(utilisateur);
            return new ResponseEntity<>("Nouvel utilisateur ajouté", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("pas ajouté");
        }

        return new ResponseEntity<>("ERREUR: impossible d'ajouter le nouvel utilisateur", HttpStatus.BAD_REQUEST);
    }

    /****************************************************************\
     * La modification et suppréssion de l'Utilisateur se fera      *
     * en cascade, depuis le controlleur AccountController          *
    \****************************************************************/
//    @PutMapping("/dashboard/update")
//    public ResponseEntity<String> modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
//        try {
//            utilisateurService.update(utilisateur);
//            return new ResponseEntity<>("Informations utilisateur modifiées", HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println("pas modifié");
//        }
//        return new ResponseEntity<>("ERREUR: impossible de modifier l'utilisateur", HttpStatus.BAD_REQUEST);
//    }
//
//    @DeleteMapping("/dashboard/delete")
//    public ResponseEntity<String> deleteUserAccount(@RequestBody Utilisateur utilisateur) {
//        try {
//            utilisateurService.delete(utilisateur);
//            return new ResponseEntity<>("Compte supprimé", HttpStatus.OK);
//        } catch (Exception e) {
//            System.out.println("pas supprimé");
//        }
//        return new ResponseEntity<>("ERREUR: impossible de supprimer l'utilisateur", HttpStatus.BAD_REQUEST);
//    }
}
