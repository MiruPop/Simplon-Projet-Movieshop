package co.simplon.movieshop.controller.user;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Commande;
import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.repository.CommandeRepository;
import co.simplon.movieshop.service.ClientService;
import co.simplon.movieshop.service.CommandeService;
import co.simplon.movieshop.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieshop/account/{id}")
public class AccountController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/commandes")
    public List<Commande> afficherCommandesClient(@PathVariable("id") Long id) {
        Client client = clientService.selectClientParId(id);
        return commandeService.commandesParClient(client);
    }

    @GetMapping("/commandes/{nrCom}")
    public Commande afficherDetailCommande(@PathVariable("id") Long id,@PathVariable("nrCom") Long nrCom) {
        return commandeService.selectCommandeParId(nrCom);
    }

    @GetMapping("/info")
    public Client afficherAccount(@PathVariable("id") Long id) {
        return clientService.selectClientParId(id);
    }

    @PutMapping("/info/update")
    public ResponseEntity<String> modifierAccount(@RequestBody Client client) {
        try {
            clientService.updateClient(client);
            return new ResponseEntity<>("Informations client modifiées", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas modifié");
        }

        return new ResponseEntity<>("ERREUR: impossible de modifier le client", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/info/delete")
    public ResponseEntity<String> deleteClient(@RequestBody Client client) {
        try {
            clientService.deleteClient(client);
            return new ResponseEntity<>("Client supprimé", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas supprimé");
        }

        return new ResponseEntity<>("ERREUR: impossible de supprimer le client", HttpStatus.BAD_REQUEST);
    }
}
