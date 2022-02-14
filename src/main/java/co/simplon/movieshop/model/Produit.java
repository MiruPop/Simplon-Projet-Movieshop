package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Produit {
    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image;

    @Column(name = "prix_unitaire")
    private Double prixUnit;

    @Column(name = "quantite_stock")
    private int quantiteStock;

    //    @OneToMany(mappedBy = "cpProduit", cascade = CascadeType.ALL,
//            orphanRemoval = true)
//    @JoinColumn(name = "id_produit")
//    private Set<Commande> commandeProduits = new HashSet<>();
//    @ElementCollection
//    @JoinTable(
//            name = "commande_produit",
//            joinColumns = @JoinColumn(name = "idProduit")
//    )
//    private List<CommandeProduit> commandeProduits;
//    @ManyToMany(mappedBy = "produits")
//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "commande_produit",
//            joinColumns = @JoinColumn(name = "id_produit"),
//            inverseJoinColumns = @JoinColumn(name = "id_commande")
//    )
//    private Set<Commande> commandes = new HashSet<>();
    @OneToMany(mappedBy = "id.idProduit")
    private Set<CommandeProduit> commandeProduits;

}
