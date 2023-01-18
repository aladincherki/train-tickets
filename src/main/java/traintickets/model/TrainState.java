package traintickets.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class TrainState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
	private String code;
	// ready
	// unready
	private String libelle;
	
	@OneToOne
	private Lang lang;

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

	public Lang getLang() {
		return lang;
	}

	public void setLang(Lang lang) {
		this.lang = lang;
	}
}
