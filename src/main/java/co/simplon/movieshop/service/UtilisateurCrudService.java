package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurCrudService {
    void addUser (Utilisateur utilisateur);
    Utilisateur findUserByEmail (String email);
    void update (Utilisateur utilisateur);
    void delete (Utilisateur utilisateur);
}
