package traintickets.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

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
