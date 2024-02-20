package com.rodrigues.onepiecerestapi.controllers;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.services.CharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/character")
@CrossOrigin(origins = "*")
@Tag(name = "Characters", description = "Endpoints for managing Characters entities")
public class CharacterController {
    private final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    @Operation(
            description = "Find all characters",
            summary = "Find all characters",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CharacterDTO.class)))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public ResponseEntity<List<CharacterDTO>> findAll(@RequestParam("crewId") Long id) {
        if (id != null && id > 0) {
            return ResponseEntity.ok().body(service.findByCrewId(id));
        }
        var list = service.findAll();

        return ResponseEntity.ok().body(list);
    }


    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    @Operation(
            description = "Find a specific character by its id",
            summary = "Find a specific character by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "id", description = "Character id", required = true)
            }
    )
    public ResponseEntity<CharacterDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    @Operation(
            description = "Create a new character",
            summary = "Create a new character",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Character to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class)
                    )
            )
    )
    public ResponseEntity<CharacterDTO> create(@RequestBody CharacterDTO character) {
        return ResponseEntity.ok().body(service.create(character));
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @Operation(
            description = "Update a character by its id",
            summary = "Update a character by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CharacterDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Character to be updated",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CharacterDTO.class)
                    )
            )
    )
    public ResponseEntity<CharacterDTO> update(@RequestBody CharacterDTO character) {
        return ResponseEntity.ok().body(service.update(character));
    }

    @DeleteMapping( value = "/{id}")
    @Operation(
            description = "Delete a character by its id",
            summary = "Delete a character by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "id", description = "Character id", required = true)
            }
    )
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
