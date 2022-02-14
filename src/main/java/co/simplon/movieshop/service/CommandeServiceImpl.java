package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Commande;
import co.simplon.movieshop.model.Produit;
import co.simplon.movieshop.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        return optionalCommande.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'id " + id));
    }

    @Override
    public List<Commande> commandesParClient(Long idClient) {
        return commandeRepository.findByClient(idClient);
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

//         Query query =
        commandeRepository.save(commande);
    }
}
