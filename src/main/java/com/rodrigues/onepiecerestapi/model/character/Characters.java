package com.rodrigues.onepiecerestapi.model.character;

import com.rodrigues.onepiecerestapi.model.crew.Crew;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Characters implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true, length = 30)
    private String name;
    private Integer age;
    private String description;
    @ElementCollection
    @CollectionTable(
            name = "character_ability",
            joinColumns = @JoinColumn(name = "character_id")
    )
    @Column(name = "ability")
    private Set<String> abilities = new HashSet<>();
    private String role;
    @ManyToOne
    private Crew crew;

    public Characters() {
    }

    public Characters(Long id, String name, Integer age, String description, Set<String> abilities, String role, Crew crew) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.description = description;
        this.abilities = abilities;
        this.role = role;
        this.crew = crew;
    }

    public Characters(CharacterDTO data) {
        this.id = data.getId();
        this.name = data.getName();
        this.age = data.getAge();
        this.description = data.getDescription();
        this.abilities = data.getAbilities();
        this.role = data.getRole();
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

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characters that = (Characters) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
