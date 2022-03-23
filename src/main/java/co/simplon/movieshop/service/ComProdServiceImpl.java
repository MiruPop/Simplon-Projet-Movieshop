package co.simplon.movieshop.service;

import co.simplon.movieshop.model.CommandeProduit;
import co.simplon.movieshop.repository.CommandeProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComProdServiceImpl implements ComProdService {
    @Autowired
    CommandeProduitRepository commandeProduitRepository;
    @Override
    public List<CommandeProduit> getByIdCommande(Long idCommande) {
        return commandeProduitRepository.findAllById_IdCommande(idCommande);
    }
}
