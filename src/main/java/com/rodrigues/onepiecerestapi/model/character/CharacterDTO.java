package com.rodrigues.onepiecerestapi.model.character;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Set;

public class CharacterDTO implements Serializable {
    @Schema(example = "3")
    private Long id;
    @Schema(example = "Nami")
    private String name;
    @Schema(example = "20")
    private Integer age;
    @Schema(example = "Navigator and Cartographer")
    private String description;
    @Schema(example = "[\"Cartography\", \"Navigation\"]")
    private Set<String> abilities;
    @Schema(example = "Navigator")
    private String role;
    @Schema(example = "1")
    private long crewId;

    public CharacterDTO(Long id, String name, Integer age, String description, Set<String> abilities, String role, long crew) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.abilities = abilities;
        this.role = role;
        this.crewId = crew;
    }

    public CharacterDTO() {
    }

    public CharacterDTO(Characters obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.age = obj.getAge();
        this.description = obj.getDescription();
        this.abilities = obj.getAbilities();
        this.role = obj.getRole();
        this.crewId = obj.getCrew().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(Set<String> abilities) {
        this.abilities = abilities;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getCrewId() {
        return crewId;
    }

    public void setCrewId(long crewId) {
        this.crewId = crewId;
    }
}
