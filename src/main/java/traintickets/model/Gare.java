package traintickets.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
public class Gare {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
    @Column(name = "libelle_fr") 
    private String libelleFr;
    
    @Column(name = "libelle_ar")
    private String libelleAr;

    @ManyToOne
    private Ville ville;
    
    @ManyToMany(mappedBy = "trajetGares")
    private Set<Trajet> trajets; 

	public Set<Trajet> getTrajets() {
		return trajets;
	}

	public void setTrajets(Set<Trajet> trajets) {
		this.trajets = trajets;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLibelleFr() {
		return libelleFr;
	}

	public void setLibelleFr(String libelleFr) {
		this.libelleFr = libelleFr;
	}

	public String getLibelleAr() {
		return libelleAr;
	}

	public void setLibelleAr(String libelleAr) {
		this.libelleAr = libelleAr;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	} 
	
}
