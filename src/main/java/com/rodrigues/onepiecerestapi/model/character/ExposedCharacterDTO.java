package com.rodrigues.onepiecerestapi.model.character;

import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;

import java.io.Serializable;
import java.util.Set;

public class ExposedCharacterDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String description;
    private Set<String> abilities;
    private String role;
    private CrewDTO crew;

    public ExposedCharacterDTO(Long id, String name, Integer age, String description, Set<String> abilities, String role, CrewDTO crew) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.abilities = abilities;
        this.role = role;
        this.crew = crew;
    }

    public ExposedCharacterDTO() {
    }

    public ExposedCharacterDTO(Characters obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.age = obj.getAge();
        this.description = obj.getDescription();
        this.abilities = obj.getAbilities();
        this.role = obj.getRole();

        if (obj.getCrew() != null) {
            this.crew = new CrewDTO(obj.getCrew());
        }
    }

    public ExposedCharacterDTO(Characters data, CrewDTO dto) {
        this.id = data.getId();
        this.name = data.getName();
        this.age = data.getAge();
        this.description = data.getDescription();
        this.abilities = data.getAbilities();
        this.role = data.getRole();
        this.crew = dto;
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

    public CrewDTO getCrew() {
        return crew;
    }

    public void setCrew(CrewDTO crew) {
        this.crew = crew;
    }
}
