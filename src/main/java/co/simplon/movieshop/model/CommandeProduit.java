package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CommandeProduit {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "idCommande", column = @Column(name = "id_commande")),
            @AttributeOverride(name = "idProduit", column = @Column(name = "id_produit")) })
    private CommandeProduitKey id;

    @Column(name = "quantite_produit")
    private int qtProduit;
}
