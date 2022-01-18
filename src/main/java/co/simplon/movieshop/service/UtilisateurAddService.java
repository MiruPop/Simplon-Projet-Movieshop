package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Utilisateur;
import org.springframework.stereotype.Service;

@Service
public interface UtilisateurAddService {
    void addUser (Utilisateur utilisateur);
}
