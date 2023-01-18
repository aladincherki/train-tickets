package traintickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import traintickets.model.Lang;
import traintickets.model.Trajet;
import traintickets.model.Ville;

public interface LangRepository extends JpaRepository<Lang, Long>{

}
