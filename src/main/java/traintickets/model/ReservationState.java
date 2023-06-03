package traintickets.model;

import java.util.UUID;

import javax.persistence.*;
import lombok.Data;

@Entity
public class ReservationState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
	
	private String code;
	
	private String libelle;
	
	@OneToOne
	private Lang lang;
}
