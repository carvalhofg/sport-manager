package io.gab.sportmanager.sport.controller;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.model.SportDTO;
import io.gab.sportmanager.sport.service.SportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    SportService sportService;

    @GetMapping
    public ResponseEntity<List<Sport>> getAllSports() {
        return new ResponseEntity<>(sportService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sport> getOneSport(@PathVariable Long id) {
        Optional<Sport> sport = sportService.findById(id);
        return sport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sport> createSport(@RequestBody SportDTO dto) {
        return new ResponseEntity<>(sportService.save(dto), HttpStatus.CREATED);
    }

}
