package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Gare;
import traintickets.model.Passager;
import traintickets.model.Place;
import traintickets.model.Reservation;
import traintickets.model.Trajet;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
