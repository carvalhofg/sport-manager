package io.gab.sportmanager.sport.service;

import java.util.List;
import java.util.Optional;

import io.gab.sportmanager.sport.model.SportDTO;
import io.gab.sportmanager.sport.model.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.gab.sportmanager.sport.model.Sport;

@Service

public class SportService {

	@Autowired
	SportRepository sportRepository;

	public SportService(SportRepository sportRepository) {
		this.sportRepository = sportRepository;
	}
	
	public List<Sport> findAll() {
		return sportRepository.findAll();
	}

	public Optional<Sport> findById(Long id) {
		return sportRepository.findById(id);
	}

	public Sport save(SportDTO sportDTO) {
		Sport sport = new Sport();
		sport.convert(sportDTO);
		return sportRepository.save(sport);
	}

}
