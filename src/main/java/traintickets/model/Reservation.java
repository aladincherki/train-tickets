package traintickets.model;

import java.util.UUID;

import javax.persistence.*;
import lombok.Data;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
	
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name = "reservation_state")
	private ReservationState reservationState; 
	
	@ManyToOne
	private Passager passager;
	
	@ManyToOne
	private Trajet trajet;
	
	@ManyToOne
	private Voiture voiture;
	
	@ManyToOne
	private Place place;
	
	
	
}
