package co.simplon.movieshop.controller.user;

import co.simplon.movieshop.dto.FactureDto;
import co.simplon.movieshop.mapper.FactureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieshop/{idCommande}/cart")
public class AchatController {
    @Autowired
    private FactureMapper factureMapper;

    @GetMapping("/livraison/pay/send")
    public FactureDto factureDto(@PathVariable("idCommande") String id) {
        return factureMapper.emmetreFacture(Long.parseLong(id));
    }
}
