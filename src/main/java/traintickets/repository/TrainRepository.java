package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Gare;
import traintickets.model.Passager;
import traintickets.model.Place;
import traintickets.model.Train;
import traintickets.model.TrainState;
import traintickets.model.Trajet;

public interface TrainRepository extends JpaRepository<Train, Long>{
	public Train findByNum(String code);
}
