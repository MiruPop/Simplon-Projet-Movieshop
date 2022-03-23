package co.simplon.movieshop.service;

import co.simplon.movieshop.model.Livraison;
import co.simplon.movieshop.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    @Autowired
    private LivraisonRepository livraisonRepository;

    @Override
    public Livraison getTypeLivrParIdCommande(Long idCommande) {
        return null;
    }
}
