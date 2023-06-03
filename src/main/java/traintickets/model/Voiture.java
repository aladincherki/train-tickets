package traintickets.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Voiture {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
	
	private Integer nbrPlace;
	
	private String num; 

    
	/*@OneToMany
	private ArrayList<Place> places ;*/
	
	/*public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}
	
	public ArrayList<Place> getPlaces() {
		return places;
	}*/

	public void setTrain(Train train) {
		this.train = train;
	}

	@ManyToOne
	private Train train;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getNbrPlace() {
		return nbrPlace;
	}

	public void setNbrPlace(Integer nbrPlace) {
		this.nbrPlace = nbrPlace;
	}




	public Train getTrain() {
		return train;
	}

	
    public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
}
