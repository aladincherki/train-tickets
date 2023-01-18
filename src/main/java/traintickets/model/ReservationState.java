package traintickets.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class ReservationState {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
	private String code;
	
	private String libelle;
	
	@OneToOne
	private Lang lang;
}
