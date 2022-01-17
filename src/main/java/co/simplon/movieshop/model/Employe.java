package co.simplon.movieshop.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employe {
    @Id
    @Column(name = "matricule")
    private String matricule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_utilisateur", nullable=false)
    private Utilisateur user;
}
