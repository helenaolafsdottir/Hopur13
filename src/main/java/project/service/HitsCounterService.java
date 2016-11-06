package project.service;

import java.util.List;

import project.persistence.entities.HitsCounter;

public interface HitsCounterService {
	
	HitsCounter save(HitsCounter hitscounter);
	
	List<HitsCounter> selectTopThree();
	

}
