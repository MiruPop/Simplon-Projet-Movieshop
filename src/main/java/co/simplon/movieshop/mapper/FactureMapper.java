package co.simplon.movieshop.mapper;

import co.simplon.movieshop.dto.FactureDto;
import co.simplon.movieshop.model.*;
import co.simplon.movieshop.repository.*;
import co.simplon.movieshop.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Component
public class FactureMapper {

    @Autowired
    CommandeRepository comRepository;
    @Autowired
    ProduitRepository prodRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    LivraisonRepository livraisonRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    CommandeProduitRepository cpRepository;

    public FactureDto emmetreFacture(Long idCommande) {
        FactureDto facture = new FactureDto();

        Commande commande = new Commande();
        Optional<Commande> optionalCommande = comRepository.findById(idCommande);
        if (optionalCommande.isPresent()) {
            commande = optionalCommande.get();
        } else {
            log.debug("Pas de commande avec l'id " + idCommande);
        }

        Client client = getClientParCommande(idCommande);
        Utilisateur utilisateur = utilisateurRepository.findByClient(client);
        Livraison livraison = livraisonRepository.getById(commande.getLivraison().getId());
        Set<HashMap<String, String>> produitsFactures = getProduitsFactures(idCommande);
        Double totalCommande = commande.getLivraison().getPrix();


        facture.setNrFacture(commande.getNrFacture());
        facture.setDateCommande(commande.getDate());
        assert client != null;
        facture.setNrClient(client.getNrClient());
        facture.setNom(utilisateur.getNom());
        facture.setPrenom(utilisateur.getPrenom());
        facture.setAdresse(client.getAdresse());
        facture.setTelephone(client.getTelephone());
        facture.setModeLivraison(livraison.getType().name());
        facture.setProduitsFactures(produitsFactures);
        for(HashMap<String, String> produitFacture : produitsFactures) {
            totalCommande += Double.parseDouble(produitFacture.get("Sous-total produit"));
        }
        facture.setMontantTotal(totalCommande);
        facture.setRefPayement(commande.getRefPayement());

        return facture;
    }


    private Client getClientParCommande(Long idCommande) {
        CommandeProduit commandeProduit = cpRepository.findFirstById_IdCommande(idCommande);
        Commande commande = comRepository.getById(commandeProduit.getId().getIdCommande());

        return commande.getClient();
    }

    private Set<HashMap<String, String>> getProduitsFactures(Long idCommande) {

        Set<HashMap<String, String>> produitsFactures = new HashSet<>();
//        Produit produit = new Produit();

        List<CommandeProduit> cpList = cpRepository.findAllById_IdCommande(idCommande);

        for (CommandeProduit cp : cpList) {
            HashMap<String, String> infosProduit = new HashMap<>();
            Produit produit = prodRepository.getById(cp.getId().getIdProduit());
            infosProduit.put("Libelle", produit.getLibelle());
            infosProduit.put("Prix unitaire", String.valueOf(produit.getPrixUnit()));
            infosProduit.put("Quantité", String.valueOf(cp.getQtProduit()));
            infosProduit.put("Sous-total produit", String.valueOf(produit.getPrixUnit() * cp.getQtProduit()));
            produitsFactures.add(infosProduit);
        }

        return produitsFactures;
    }

    private Optional<Commande> getCommande(Long id) {
        return comRepository.findById(id);
    }

//    @Autowired
//    private CommandeService commandeService;
//    @Autowired
//    private ProduitService produitService;
//    @Autowired
//    private ClientService clientService;
//    @Autowired
//    private UtilisateurService utilisateurService;
//    @Autowired
//    private ComProdService comProdService;
//
//    public FactureDto emmetreFacture(Long idCommande) {
//        FactureDto facture = new FactureDto();
//
//        Commande commande = commandeService.selectCommandeParId(idCommande);
//        Client client = clientService.getClientParCommande(idCommande);
//        Utilisateur utilisateur = utilisateurService.getUserByClient(client);
//        Set<HashMap<String, String>> produitsFactures = getProduitsFactures(idCommande);
//        Double totalCommande = commande.getLivraison().getPrix();
//
//
//        facture.setNrFacture(commande.getNrFacture());
//        facture.setDateCommande(commande.getDate());
//        facture.setNrClient(client.getNrClient());
//        facture.setNom(utilisateur.getNom());
//        facture.setPrenom(utilisateur.getPrenom());
//        facture.setAdresse(client.getAdresse());
//        facture.setTelephone(client.getTelephone());
//        facture.setModeLivraison(commande.getLivraison().getType().toString());
//        facture.setProduitsFactures(produitsFactures);
//        for (HashMap<String, String> produitFacture : produitsFactures) {
//            totalCommande += Double.parseDouble(produitFacture.get("Sous-total"));
//        }
//        facture.setMontantTotal(totalCommande);
//        facture.setRefPayement(commande.getRefPayement());
//
//        return facture;
//    }
//
//    private Set<HashMap<String, String>> getProduitsFactures(Long idCommande) {
//
//        Set<HashMap<String, String>> produitsFactures = new HashSet<>();
//        List<CommandeProduit> cpList = comProdService.getByIdCommande(idCommande);
//
//        for (CommandeProduit cp : cpList) {
//            HashMap<String, String> infosProduit = new HashMap<>();
//            Produit produit = produitService.selectProduitParId(cp.getId().getIdProduit());
//            infosProduit.put("Libelle", produit.getLibelle());
//            infosProduit.put("Prix unitaire", String.valueOf(produit.getPrixUnit()));
//            infosProduit.put("Quantité", String.valueOf(cp.getQtProduit()));
//            infosProduit.put("Sous-total produit", String.valueOf(produit.getPrixUnit() * cp.getQtProduit()));
//            produitsFactures.add(infosProduit);
//        }
//
//        return produitsFactures;
//    }
}
