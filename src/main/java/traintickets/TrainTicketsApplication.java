package traintickets;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import traintickets.commun.enums.TrainTypeEnum;
import traintickets.commun.util.Constantes;
import traintickets.model.Gare;
import traintickets.model.Lang;
import traintickets.model.Place;
import traintickets.model.Train;
import traintickets.model.TrainState;
import traintickets.model.Trajet;
import traintickets.model.Ville;
import traintickets.model.Voiture;
import traintickets.repository.GareRepository;
import traintickets.repository.LangRepository;
import traintickets.repository.PlaceRepository;
import traintickets.repository.TrainRepository;
import traintickets.repository.TrainStateRepository;
import traintickets.repository.VilleRepository;
import traintickets.repository.VoitureRepository;
import traintickets.service.ITrajetService;

@ComponentScan(basePackages = "traintickets.*")
@SpringBootApplication
public class TrainTicketsApplication implements CommandLineRunner{
	
	@Autowired
	private VilleRepository villeRepository;
	
	@Autowired
	private LangRepository langRepository;
	
	@Autowired
	private TrainStateRepository trainStateRepository;
	
	@Autowired
	private TrainRepository trainRepository;
	
	@Autowired
	private GareRepository gareRepository;
	
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private PlaceRepository placeRepository;
	
	@Autowired
	private ITrajetService trajetService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TrainTicketsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// save villes
		villeRepository.saveAll(getVilles());
		
		// save langs	
		langRepository.saveAll(getLangs());
		
		// save TrainState
		trainStateRepository.saveAll(getTrainState());
		
		// save a train 
		Train train = trainRepository.save(getTrain());
		
		// save gares
		this.gareRepository.saveAll(getGares());
		
		
		// save voitures
		
		Voiture voiture1 = new Voiture();
		voiture1.setId(UUID.randomUUID());
		voiture1.setNbrPlace(10);
		voiture1.setNum("21");
		voiture1.setTrain(train);
		//voiture1.setPlaces(getPlaces());
		Voiture savedVoiture = this.voitureRepository.save(voiture1);
		
		// save places
		this.placeRepository.saveAll(getPlaces(savedVoiture));
		
		//Trajet savedTrajet =   this.trajetService.insertTrajet(train);
		
		//System.out.println("--------------------- TESTING-----------------------" +savedTrajet);
		
		
		
		
	}
	
	private ArrayList<Ville> getVilles() {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Ville ville1 = new Ville();
		ville1.setId(UUID.randomUUID());
		ville1.setLibelleFr(Constantes.FR_RABAT_CITY);
		ville1.setLibelleAr(Constantes.AR_RABAT_CITY);
		
		Ville ville2 = new Ville();
		ville2.setId(UUID.randomUUID());
		ville2.setLibelleFr(Constantes.FR_CASA_CITY);
		ville2.setLibelleAr(Constantes.AR_CASA_CITY);
		
		Ville ville3 = new Ville();
		ville3.setId(UUID.randomUUID());
		ville3.setLibelleFr(Constantes.FR_MARRAKECH_CITY);
		ville3.setLibelleAr(Constantes.AR_MARRAKECH_CITY);
		villes.add(ville1);
		villes.add(ville2);
		villes.add(ville3);
		return villes;
	}
	
	private ArrayList<TrainState> getTrainState() {
		ArrayList<TrainState> trainStates = new ArrayList<TrainState>();
		TrainState trainState1 = new TrainState();
		trainState1.setId(UUID.randomUUID());
		trainState1.setCode(Constantes.READY_TRAIN_STATE_CODE);
		trainState1.setLibelle(Constantes.READY_TRAIN_STATE_LIBELLE);
		trainStates.add(trainState1);
		
		TrainState trainState2 = new TrainState();
		trainState2.setId(UUID.randomUUID());
		trainState2.setCode(Constantes.UNREADY_TRAIN_STATE_CODE);
		trainState2.setLibelle(Constantes.UNREADY_TRAIN_STATE_LIBELLE);
		trainStates.add(trainState2);
		return trainStates;
	}
	
	private ArrayList<Lang> getLangs() {
		ArrayList<Lang> langs = new ArrayList<Lang>();
		Lang lang1 = new Lang();
		lang1.setId(UUID.randomUUID());
		lang1.setCode(Constantes.FR_LANG_CODE);
		lang1.setLibelle(Constantes.FR_LANG_LIBELLE);
		
		Lang lang2 = new Lang();
		lang2.setId(UUID.randomUUID());
		lang2.setCode(Constantes.AR_LANG_CODE);
		lang2.setLibelle(Constantes.AR_LANG_LIBELLE);
		langs.add(lang2);
		langs.add(lang1);
		return langs;
	}
	
	private Train getTrain() {
		Train train = new Train();
		train.setId(UUID.randomUUID());
		train.setNum("104");
		train.setState(trainStateRepository.findByCode(Constantes.READY_TRAIN_STATE_CODE));
		train.setTrainType(TrainTypeEnum.TL);
		
		return train;
	}  
	
	private ArrayList<Gare> getGares() {
		ArrayList<Gare> gares = new ArrayList<Gare>();
		Gare gare1 = new Gare();
		gare1.setId(UUID.randomUUID());
		gare1.setLibelleFr(Constantes.FR_GARE_RABAT_VILLE);
		gare1.setLibelleAr(Constantes.AR_GARE_RABAT_VILLE);
		gare1.setVille(villeRepository.findByLibelleFr(Constantes.FR_RABAT_CITY));
		gares.add(gare1);
		
		Gare gare2 = new Gare();
		gare2.setId(UUID.randomUUID());
		gare2.setLibelleFr(Constantes.FR_GARE_CASA_OUASIS);
		gare2.setLibelleAr(Constantes.AR_GARE_CASA_OUASIS);
		gare2.setVille(villeRepository.findByLibelleFr(Constantes.FR_CASA_CITY));
		gares.add(gare2);
		
		Gare gare3 = new Gare();
		gare3.setId(UUID.randomUUID());
		gare3.setLibelleFr(Constantes.FR_GARE_MARRAKECH);
		gare3.setLibelleAr(Constantes.AR_GARE_MARRAKECH);
		gare3.setVille(villeRepository.findByLibelleFr(Constantes.FR_MARRAKECH_CITY));
		gares.add(gare3);
		
		return gares;

	}
	
	private ArrayList<Place> getPlaces(Voiture voiture) {
		ArrayList<Place> places = new ArrayList<Place>();
		for(int i = 1; i <= 10; i++) {
			Place place = new Place();
			place.setId(UUID.randomUUID());
			place.setNum(i);
			place.setVoiture(voiture);
			places.add(place);
		}
		return places;
	}
	
	private ArrayList<Voiture> getVoiture(Train train) {
		ArrayList<Voiture> voitures = new ArrayList<Voiture>();
		Voiture voiture1 = new Voiture();
		voiture1.setId(UUID.randomUUID());
		voiture1.setNbrPlace(10);
		voiture1.setNum("21");
		voiture1.setTrain(train);
		voitures.add(voiture1);
		
		return voitures;
	}


}
