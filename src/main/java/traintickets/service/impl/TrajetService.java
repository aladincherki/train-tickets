package traintickets.service.impl;

import traintickets.model.Train;
import traintickets.model.Gare;
import traintickets.model.Trajet;
import traintickets.repository.GareRepository;
import traintickets.repository.TrajetRepository;
import traintickets.service.ITrajetService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import traintickets.commun.util.Constantes;

@Service
public class TrajetService implements ITrajetService {

	@Autowired
	public TrajetRepository trajetRepository;
	
	@Autowired
	public GareRepository gareRepository;
	
	@Override
	public void insertTrajet(Train train) {
		Trajet trajet = new Trajet();
		Set<Gare> gares = new HashSet<Gare>();
		gares.add(this.gareRepository.getByLibelleFr(Constantes.FR_GARE_MARRAKECH));
		gares.add(this.gareRepository.getByLibelleFr(Constantes.FR_GARE_CASA_OUASIS));
		gares.add(this.gareRepository.getByLibelleFr(Constantes.FR_GARE_RABAT_VILLE));
		if(train.getState().getCode().equals(Constantes.READY_TRAIN_STATE_CODE)) {
			//trajet.setId(UUID.randomUUID());
			trajet.setTrain(train);
			trajet.setTrajetGares(gares);
			trajet.setTrainType(train.getTrainType());
			trajet.setState(train.getState());
			Trajet savedTrajet = this.trajetRepository.save(trajet);		
		} 
		
	}

}
