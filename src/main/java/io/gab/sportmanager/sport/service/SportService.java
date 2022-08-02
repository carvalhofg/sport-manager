package io.gab.sportmanager.sport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.gab.sportmanager.sport.model.Sport;

@Service
public interface SportService {

	List<Sport> findAll();
	Optional<Sport> findById(Long id);
	Sport save(Sport sport);
}
