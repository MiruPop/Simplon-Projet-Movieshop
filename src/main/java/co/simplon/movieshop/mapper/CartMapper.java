package co.simplon.movieshop.mapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CartMapper {
    /***********************************************************************\
     * Implémenter un objet Panier, contenant une clé étrangère "idClient" *
     * Cette objet contiendra une liste de produits séléctionnés par le    *
     * Client, ainsi que la quantité souhaitée.                            *
     * Il sera utilisé dans la route /movieshop/cart et enrichi, aux étapes*
     * suivantes, par un ModeLivraison et une RefPayement, qui permettra   *
     * l'ajout dans la BDD d'une nouvelle Commande                         *
    \***********************************************************************/
}
