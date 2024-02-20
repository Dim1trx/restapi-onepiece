package com.rodrigues.onepiecerestapi.unittests.mapper;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.character.MemberDTO;
import com.rodrigues.onepiecerestapi.model.crew.Crew;
import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;
import com.rodrigues.onepiecerestapi.unittests.mapper.mocks.MockCharacter;
import com.rodrigues.onepiecerestapi.unittests.mapper.mocks.MockCrew;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelMapperTests {
    static ModelMapper mapper;
    static MockCharacter characterInput;
    static MockCrew crewInput;

    @BeforeAll
    public static void setUp() {
        characterInput = new MockCharacter();
        crewInput = new MockCrew();
        mapper = new ModelMapper();
    }

    @Test
    public void CharacterstoCharacterDTOTest() {
        Characters obj = MockCharacter.mockEntity(1);

        CharacterDTO dto = mapper.map(obj, CharacterDTO.class);

        assertEquals(obj.getId(), dto.getId());
        assertEquals(obj.getName(), dto.getName());
        assertEquals(obj.getAge(), dto.getAge());
        assertEquals(obj.getDescription(), dto.getDescription());
        assertEquals(obj.getAbilities(), dto.getAbilities());
        assertEquals(obj.getRole(), dto.getRole());
        assertEquals(obj.getCrew().getId(), dto.getCrewId());
    }

    @Test
    public void CharacterDTOtoCharacters() {
        CharacterDTO dto = MockCharacter.mockDTO(1);

        Characters obj = mapper.map(dto, Characters.class);

        assertEquals(dto.getId(), obj.getId());
        assertEquals(dto.getName(), obj.getName());
        assertEquals(dto.getAge(), obj.getAge());
        assertEquals(dto.getDescription(), obj.getDescription());
        assertEquals(dto.getAbilities(), obj.getAbilities());
        assertEquals(dto.getRole(), obj.getRole());
        assertEquals(dto.getCrewId(), 0L);
    }

    @Test
    public void CharactersToMemberDTO() {
        Characters obj = MockCharacter.mockEntity(1);

        MemberDTO dto = mapper.map(obj, MemberDTO.class);

        assertEquals(obj.getId(), dto.getId());
        assertEquals(obj.getName(), dto.getName());
        assertEquals(obj.getRole(), dto.getRole());
    }

    @Test
    public void CrewToCrewDTO() {
        Crew crew = MockCrew.mockEntity(1);

        CrewDTO dto = mapper.map(crew, CrewDTO.class);

        assertEquals(crew.getId(), dto.getId());
        assertEquals(crew.getName(), dto.getName());
        assertEquals(crew.getMembers().size(), dto.getMembers().size());
    }

    @Test
    public void CrewDTOToCrew() {
        CrewDTO dto = MockCrew.mockDTO(1);

        Crew crew = mapper.map(dto, Crew.class);

        assertEquals(dto.getId(), crew.getId());
        assertEquals(dto.getName(), crew.getName());
        assertEquals(dto.getMembers().size(), crew.getMembers().size());
    }
}