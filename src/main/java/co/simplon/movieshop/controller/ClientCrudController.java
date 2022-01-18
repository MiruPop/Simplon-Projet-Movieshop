package co.simplon.movieshop.controller;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.service.ClientCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieshop/admin/client")
public class ClientCrudController {

    @Autowired
    private ClientCrudService clientCrudService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> listerClients() {
        List<Client> liste = clientCrudService.getAllClients();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Client trouverUnClient(@PathVariable("id") String id) {
        return clientCrudService.selectClientParId(Long.parseLong(id));
    }

    @PostMapping("/add")
    public ResponseEntity<String> ajouterClient(@RequestBody Client client) {
        try {
            clientCrudService.addClient(client);
            return new ResponseEntity<>("Nouveau client ajouté", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("pas ajouté");
        }

        return new ResponseEntity<>("ERREUR: impossible d'ajouter un nouveau client", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<String> modifierClient(@RequestBody Client client) {
        try {
            clientCrudService.updateClient(client);
            return new ResponseEntity<>("Informations client modifiées", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas modifié");
        }

        return new ResponseEntity<>("ERREUR: impossible de modifier le client", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteClient(@RequestBody Client client) {
        try {
            clientCrudService.deleteClient(client);
            return new ResponseEntity<>("Client supprimé", HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("pas supprimé");
        }

        return new ResponseEntity<>("ERREUR: impossible de supprimer le client", HttpStatus.BAD_REQUEST);
    }

}
