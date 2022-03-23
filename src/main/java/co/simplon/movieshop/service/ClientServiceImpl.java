package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Commande;
import co.simplon.movieshop.model.CommandeProduit;
import co.simplon.movieshop.repository.ClientRepository;
import co.simplon.movieshop.repository.CommandeProduitRepository;
import co.simplon.movieshop.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CommandeProduitRepository comProdRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client selectClientParId(Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        return optionalClient.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'id "+ id));
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public Client getClientParCommande(Long idCommande) {
        CommandeProduit commandeProduit = comProdRepository.findFirstById_IdCommande(idCommande);
        Commande commande = commandeRepository.getById(commandeProduit.getId().getIdCommande());

        return commande.getClient();
    }

     /********************************************\
      *                   CLIENT                 *
     \********************************************/

     @Override
     public void addClient(Client client) {
         clientRepository.save(client);
     }

}
