package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Gare;
import traintickets.model.Passager;
import traintickets.model.Place;
import traintickets.model.Trajet;
import traintickets.model.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Long>{
	public Voiture findByNum(String num); 
}
