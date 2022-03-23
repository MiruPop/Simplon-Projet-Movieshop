package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Client;
import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Component
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository userRepository;

    /****************************************************************\
     * A REVOIR les services et routes de l'Utilisateur pour        *
     * permettre l'echange sécurisé d'informations                  *
     \****************************************************************/

    @Override
    public void addUser(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findUserByEmail(String email) {
        Optional<Utilisateur> utilisateurOptionnel = userRepository.findByEmail(email);
        return utilisateurOptionnel.orElseThrow(() -> new NoSuchElementException("Pas d'élément avec l'email " + email));
    }

    @Override
    public void update(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }

    @Override
    public void delete(Utilisateur utilisateur) {
        userRepository.delete(utilisateur);
    }

    @Override
    public Utilisateur getUserByClient(Client client) {
        return userRepository.findByClient(client);
    }
}
