package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Gare;
import traintickets.model.Passager;
import traintickets.model.Trajet;

public interface PassagerRepository extends JpaRepository<Passager, Long>{

}
