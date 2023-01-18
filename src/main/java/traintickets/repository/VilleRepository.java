package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.TrainState;
import traintickets.model.Trajet;
import traintickets.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, Long>{
	public Ville findByLibelleFr(String libelle);
}
