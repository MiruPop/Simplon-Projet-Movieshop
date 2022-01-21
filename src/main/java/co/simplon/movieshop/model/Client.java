package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @Column(name = "numero_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nrClient;

    @Column(name = "adresse_livraison")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    private Utilisateur user;
}
