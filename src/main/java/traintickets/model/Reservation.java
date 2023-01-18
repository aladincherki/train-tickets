package traintickets.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
