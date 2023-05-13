package traintickets.batch;

import java.util.List;

import org.springframework.batch.item.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import traintickets.model.Train;
import traintickets.model.Trajet;
import traintickets.service.ITrajetService;

@Component
public class TrajetWriter implements ItemWriter<Train> {

	private ITrajetService trajetService;
	
	@Override
	public void write(List<? extends Train> trains) throws Exception {
		// TODO Auto-generated method stub
		trains.forEach(train -> {
			trajetService.insertTrajet(train);
		});
		
	}

}
