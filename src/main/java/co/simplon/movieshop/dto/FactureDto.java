package co.simplon.movieshop.dto;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Data
public class FactureDto {
    private String nrFacture;
    private Date dateCommande;
    private Long nrClient;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private Set<HashMap<String,String>> produitsFactures;
    private String modeLivraison;
    private Double montantTotal;
    private String refPayement;
}
