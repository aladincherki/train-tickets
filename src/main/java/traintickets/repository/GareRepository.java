package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Gare;
import traintickets.model.Train;
import traintickets.model.Trajet;

public interface GareRepository extends JpaRepository<Gare, Long>{
	public Gare getByLibelleFr(String libelleFr);
}
