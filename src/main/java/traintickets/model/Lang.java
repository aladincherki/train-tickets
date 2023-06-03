package traintickets.model;

import java.util.UUID;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
public class Lang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
	
	private String code;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	private String libelle;
}
