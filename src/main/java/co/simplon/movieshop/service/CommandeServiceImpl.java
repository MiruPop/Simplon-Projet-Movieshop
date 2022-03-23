package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Commande;
import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.repository.CommandeProduitRepository;
import co.simplon.movieshop.repository.CommandeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;


    /********************************************\
     *                   ADMIN                  *
    \********************************************/

    @Override
    public List<Commande> listerCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande selectCommandeParId(Long id) {
        Optional<Commande> optionalCommande = commandeRepository.findByNrCommande(id);
        return optionalCommande.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'id " + id));
    }

    @Override
    public List<Commande> commandesParClient(Client client) {
        return commandeRepository.findByClient(client);
    }


    @Override
    public void modifierCommande(Commande commande) {
        commandeRepository.save(commande);
    }

    /********************************************\
     *                   CLIENT                 *
     \********************************************/

    @Override
    public void passerCommande(Commande commande, List<Produit> listeProd) {
        commandeRepository.save(commande);
    }
}
