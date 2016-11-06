package project.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import project.persistence.entities.HitsCounter;
import project.persistence.repositories.HitsCounterRepository;
import project.service.HitsCounterService;

public class HitsCounterServiceImplementation implements HitsCounterService {
	
		HitsCounterRepository repository;
	    
	    // Dependency Injection
		@Autowired
	    public HitsCounterServiceImplementation(HitsCounterRepository repository) {
	        this.repository = repository;
	    }
	
		public HitsCounter save(HitsCounter hitscounter){
			return repository.save(hitscounter);
		}
		
		public List<HitsCounter> selectTopThree(){
			return repository.selectTopThree();
		}

}
