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

    @OneToMany(mappedBy = "id.idProduit")
    private Set<CommandeProduit> commandeProduits;

}
