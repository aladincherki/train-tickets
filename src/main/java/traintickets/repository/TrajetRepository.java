package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet, Long>{

}
