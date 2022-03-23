package co.simplon.movieshop.controller.user;

import co.simplon.movieshop.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieshop/cart")
public class CartController {
    @Autowired
    CommandeService commandeService;
}
