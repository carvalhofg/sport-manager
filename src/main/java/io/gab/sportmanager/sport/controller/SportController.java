package io.gab.sportmanager.sport.controller;

import io.gab.sportmanager.sport.model.Sport;
import io.gab.sportmanager.sport.service.SportServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sport")
public class SportController {

    private final SportServiceImpl sportService;

    public SportController(SportServiceImpl sportService) {
        this.sportService = sportService;
    }

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
    public ResponseEntity<Sport> createSport(@RequestBody Sport sport) {
        return new ResponseEntity<>(sportService.save(sport), HttpStatus.CREATED);
    }

}
