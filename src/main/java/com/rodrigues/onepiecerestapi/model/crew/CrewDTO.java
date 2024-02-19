package com.rodrigues.onepiecerestapi.model.crew;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.character.MemberDTO;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CrewDTO implements Serializable {
    @Schema(example = "1")
    private long id;
    @Schema(example = "Straw Hat Pirates")
    private String name;
    @Schema
    private List<MemberDTO> members = new ArrayList<>();

    public CrewDTO(long id, String name, List<MemberDTO> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public CrewDTO(Crew data) {
        this.id = data.getId();
        this.name = data.getName();

        for (Characters member : data.getMembers()) {
            this.members.add(new MemberDTO(member.getId(), member.getName(), member.getRole()));
        }
    }

    public CrewDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MemberDTO> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDTO> members) {
        this.members = members;
    }
}
