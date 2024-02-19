package com.rodrigues.onepiecerestapi.model.character;

import java.io.Serializable;

public class MemberDTO implements Serializable {
    private long id;
    private String name;
    private String role;

    public MemberDTO(long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }


    public MemberDTO() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
