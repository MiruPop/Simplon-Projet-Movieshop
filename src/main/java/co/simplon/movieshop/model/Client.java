package co.simplon.movieshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @Column(name = "numero_client")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nrClient;

    @Column(name = "adresse_livraison")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    private Utilisateur user;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Commande> commandes = new ArrayList<>();
}
