package com.rodrigues.onepiecerestapi.model.crew;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "crew")
public class Crew implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @OneToMany(mappedBy = "crew", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Characters> members;

    public Crew(Long id, String name, List<Characters> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public Crew() {
    }

    public Crew(CrewDTO crew) {
        this.id = crew.getId();
        this.name = crew.getName();

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

    public List<Characters> getMembers() {
        return members;
    }

    public void setMembers(List<Characters> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(id, crew.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
