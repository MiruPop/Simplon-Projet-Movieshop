package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class CommandeProduitKey implements Serializable {
    @Column(name = "id_commande")
    Long idCommande;
    @Column(name = "id_produit")
    Long idProduit;
}
