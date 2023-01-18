package traintickets.model;

import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import traintickets.commun.converter.TrainTypeConverter;
import traintickets.commun.enums.TrainTypeEnum;

@Entity
public class Trajet {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
	
	@Convert(converter = TrainTypeConverter.class)
	@JsonProperty("train_type")
	private TrainTypeEnum trainType;
	
	@ManyToOne
	private TrainState state;
	
	@ManyToMany
	@JoinTable(
	  name = "gare_trajet", 
	  joinColumns = @JoinColumn(name = "trajet_id"), 
	  inverseJoinColumns = @JoinColumn(name = "gare_id"))
	Set<Gare> trajetGares;
	
	@ManyToOne
	private Train train;

	public Set<Gare> getTrajetGares() {
		return trajetGares;
	}

	public void setTrajetGares(Set<Gare> trajetGares) {
		this.trajetGares = trajetGares;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public TrainTypeEnum getTrainType() {
		return trainType;
	}

	public void setTrainType(TrainTypeEnum trainType) {
		this.trainType = trainType;
	}

	public TrainState getState() {
		return state;
	}

	public void setState(TrainState state) {
		this.state = state;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}
	
}
