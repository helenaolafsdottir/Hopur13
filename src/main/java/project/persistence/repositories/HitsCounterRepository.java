package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.HitsCounter;


public interface HitsCounterRepository extends JpaRepository<HitsCounter, Long>{
	  
	  HitsCounter save(HitsCounter hitscounter);
	    
	  @Query("SELECT h.id FROM HitsCounter h ORDER BY h.counter DESC LIMIT 3")
	  List<HitsCounter> selectTopThree();
		
}

