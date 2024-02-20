package com.rodrigues.onepiecerestapi.unittests.mapper.mocks;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.crew.Crew;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockCharacter {
    public static Characters mockEntity(int n){
        Crew crew = MockCrew.mockEntity(n);

        Set<String> abilities = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            abilities.add("Ability" + n);
        }
        Characters obj = new Characters(
                (long) n,
                "Name " + n,
                10 + n,
                "Description" + n,
                abilities,
                "Role" + n,
                crew
        );

        return obj;
    }

    public static List<Characters> mockList(int n) {
        List<Characters> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(mockEntity(n));
        }

        return list;
    }

    public static CharacterDTO mockDTO(int n) {
        Set<String> abilities = new HashSet<String>();

        for (int i = 0; i < n; i++) {
            abilities.add("Ability" + n);
        }

        return new CharacterDTO(
                (long) n,
                "Name " + n,
                10 + n,
                "Description" + n,
                abilities,
                "Role" + n,
                0L
        );
    }
}
