package io.gab.sportmanager.sport.service;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportRepository;

import java.util.List;
import java.util.Optional;

public class SportServiceImpl implements SportService {

    private final SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    @Override
    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    @Override
    public Optional<Sport> findById(Long id) {
        return sportRepository.findById(id);
    }

    @Override
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

}
