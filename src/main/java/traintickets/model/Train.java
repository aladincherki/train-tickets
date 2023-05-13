package traintickets.model;

import java.util.ArrayList;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import traintickets.commun.converter.TrainTypeConverter;
import traintickets.commun.enums.TrainTypeEnum;

@Entity
public class Train {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    
    @Column(unique = true)
	private String num;
	
	@Convert(converter = TrainTypeConverter.class)
	@JsonProperty("train_type")
	private TrainTypeEnum trainType;
	
	@ManyToOne
	private TrainState state;
	
	/*@OneToMany
	private ArrayList<Voiture> voitures;
	
	public ArrayList<Voiture> getVoitures() {
		return voitures;
	}*/

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
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
}
