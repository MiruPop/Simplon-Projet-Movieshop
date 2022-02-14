package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /* l'utilisation de l'annotation @Enumerated, en précisant le type String
    * est suffisante ici, car il n'y a pas beaucoup d'entrées dans l'Enum
    * mais ça rend le refactoring de la couche de persistence laborieux
    * La meilleure sollution est de créer une classe intermédiaire pour mapper l'Enum,
    * qui implémente l'intérface AttributeConcerter, annotée avec @Converter. On ajoute alors
    * sur l'attribut type Enum l'annotation @Convert(converter = NomDuMapper.class)
    *********** https://thorben-janssen.com/hibernate-enum-mappings/ ********************
    */
    @Enumerated(EnumType.STRING)
    private ModeLivraisonEnum type;

    @Column(name = "prix")
    private Double prix;

    @OneToMany(
            mappedBy = "livraison",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commande> commandes = new ArrayList<>();

}
