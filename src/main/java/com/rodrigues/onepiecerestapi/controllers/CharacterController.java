package com.rodrigues.onepiecerestapi.controllers;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.model.character.ExposedCharacterDTO;
import com.rodrigues.onepiecerestapi.services.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/character")
@CrossOrigin(origins = "*")

public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    public ResponseEntity<List<ExposedCharacterDTO>> findAll() {
        var list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    public ResponseEntity<ExposedCharacterDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    public ResponseEntity<ExposedCharacterDTO> create(@RequestBody CharacterDTO character) {
        return ResponseEntity.ok().body(service.create(character));
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<ExposedCharacterDTO> update(@RequestBody CharacterDTO character) {
        return ResponseEntity.ok().body(service.update(character));
    }

    @DeleteMapping( value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
