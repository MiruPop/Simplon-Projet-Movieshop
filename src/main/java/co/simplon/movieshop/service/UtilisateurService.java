package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurService {
    void addUser (Utilisateur utilisateur);
    Utilisateur findUserByEmail (String email);
    void update (Utilisateur utilisateur);
    void delete (Utilisateur utilisateur);
    Utilisateur getUserByClient(Client client);
}
