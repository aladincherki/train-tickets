package traintickets.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.*;

import javax.persistence.*;

@Entity
public class Ville {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
	
    @Column(name = "libelle_fr") 
    private String libelleFr;
    
    @Column(name = "libelle_ar")
    private String libelleAr;

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
	
	
}
