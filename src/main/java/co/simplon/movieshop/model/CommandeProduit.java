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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_commande", insertable=false, updatable=false)
//    private Commande cpCommande;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_produit", insertable=false, updatable=false)
//    private Produit cpProduit;

    @Column(name = "quantite_produit")
    private int qtProduit;
}
