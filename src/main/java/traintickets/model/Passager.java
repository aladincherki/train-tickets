package traintickets.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Passager {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
	
    private String cin;
    
    private String nom;
    
    private String prenom;
	
	
}
