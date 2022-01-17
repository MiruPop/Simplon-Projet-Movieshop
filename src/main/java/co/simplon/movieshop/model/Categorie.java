package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categorie")
    private Integer id;

    @Column(name = "nom")
    private String nom;
}
