package co.simplon.movieshop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nr_commande")
    private Long nrCommande;

    @Column(name = "date")
    private Date date;

    @Column(name = "montant_total")
    private Double total;

    @Column(name = "nr_facture")
    private String facture;

    @Column(name = "reference_payement")
    private String refPayement;


    @ManyToOne
    @JoinColumn(name = "id_client", nullable=false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_livraison", nullable=false)
    private Livraison livraison;
}
