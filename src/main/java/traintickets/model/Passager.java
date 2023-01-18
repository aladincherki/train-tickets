package traintickets.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

import jakarta.persistence.*;


@Entity
public class Passager {
	
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
	
    private String cin;
    
    private String nom;
    
    private String prenom;
	
	
}
