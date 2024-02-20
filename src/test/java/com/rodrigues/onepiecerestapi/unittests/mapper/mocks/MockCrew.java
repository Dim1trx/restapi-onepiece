package com.rodrigues.onepiecerestapi.unittests.mapper.mocks;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.character.MemberDTO;
import com.rodrigues.onepiecerestapi.model.crew.Crew;
import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;

import java.util.ArrayList;
import java.util.List;

public class MockCrew {
    public static Crew mockEntity(int n) {
        List<Characters> members = new ArrayList<>();

        return new Crew(
                (long) n,
                "Name" + n,
                members
        );
    }

    public static Crew mockCrew(int n) {
        List<Characters> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            members.add(MockCharacter.mockEntity(n));
        }

        return new Crew(
                (long) n,
                "Name" + n,
                members
        );
    }

    public static CrewDTO mockDTO(int n) {
        List<MemberDTO> list = new ArrayList<>();

        return new CrewDTO(
                (long) n,
                "Name" + n,
                list
        );
    }
}
