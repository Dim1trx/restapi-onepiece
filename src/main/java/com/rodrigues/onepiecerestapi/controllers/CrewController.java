package com.rodrigues.onepiecerestapi.controllers;

import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;
import com.rodrigues.onepiecerestapi.services.CrewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/crew")
@CrossOrigin(origins = "*")
@Tag(name = "Crew", description = "Endpoints for managing Crew entities")
public class CrewController {
    private final CrewService service;

    public CrewController(CrewService service) {
        this.service = service;
    }

    @GetMapping(
            produces = "application/json"
    )
    @Operation(
            description = "Find all crews",
            summary = "Find all crews",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = CrewDTO.class)))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    public ResponseEntity<List<CrewDTO>> findAll() {
        var list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    @Operation(
            description = "Find a specific crew by its id",
            summary = "Find a specific crew by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CrewDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "id", description = "Crew id", required = true)
            }
    )
    public ResponseEntity<CrewDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @CrossOrigin(origins = "*")
    @Operation(
            description = "Create a new crew",
            summary = "Create a new crew",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CrewDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            requestBody = @RequestBody(
                    description = "Crew to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CrewDTO.class)
                    )
            )
    )
    public ResponseEntity<CrewDTO> create(@RequestBody CrewDTO crew) {
        return ResponseEntity.ok().body(service.create(crew));
    }

    @PutMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    @Operation(
            description = "Update a crew by its id",
            summary = "Update a crew by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json", schema = @Schema(implementation = CrewDTO.class))
                            }
                    ),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            requestBody = @RequestBody(
                    description = "Crew to be updated",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CrewDTO.class)
                    )
            )
    )
    public ResponseEntity<CrewDTO> update(@RequestBody CrewDTO crew) {
        return ResponseEntity.ok().body(service.update(crew));
    }

    @DeleteMapping( value = "/{id}")
    @Operation(
            description = "Delete a crew by its id",
            summary = "Delete a crew by its id",
            responses = {
                    @ApiResponse(description = "Successful operation", responseCode = "200"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "404", description = "Not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            },
            parameters = {
                    @Parameter(name = "id", description = "Crew id", required = true)
            }
    )
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);

        return ResponseEntity.ok().build();
    }
}
