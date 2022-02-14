package co.simplon.movieshop.controller;

import co.simplon.movieshop.dto.FactureDto;
import co.simplon.movieshop.service.AchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieshop/admin/facture")
public class AchatController {
    @Autowired
    private AchatService achatService;

    @GetMapping("/{id}")
    public FactureDto factureDto(@PathVariable("id") String id) {
        return achatService.emmetreFacture(Long.parseLong(id));
    }
}
