package com.rodrigues.onepiecerestapi.controllers;

import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;
import com.rodrigues.onepiecerestapi.services.CrewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/crew")
@CrossOrigin(origins = "*")
public class CrewController {
    private final CrewService service;

    public CrewController(CrewService service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<List<CrewDTO>> findAll() {
        var list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<CrewDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    public ResponseEntity<CrewDTO> create(@RequestBody CrewDTO crew) {
        return ResponseEntity.ok().body(service.create(crew));
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<CrewDTO> update(@RequestBody CrewDTO crew) {
        return ResponseEntity.ok().body(service.update(crew));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
