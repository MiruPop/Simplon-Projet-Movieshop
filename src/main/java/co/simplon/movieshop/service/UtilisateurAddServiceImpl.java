package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Utilisateur;
import co.simplon.movieshop.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UtilisateurAddServiceImpl implements UtilisateurAddService {
    @Autowired
    UtilisateurRepository userRepository;

    @Override
    public void addUser(Utilisateur utilisateur) {
        userRepository.save(utilisateur);
    }
}
