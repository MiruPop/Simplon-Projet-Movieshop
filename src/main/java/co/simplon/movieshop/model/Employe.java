package co.simplon.movieshop.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matricule")
    private Long matricule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur user;
}
