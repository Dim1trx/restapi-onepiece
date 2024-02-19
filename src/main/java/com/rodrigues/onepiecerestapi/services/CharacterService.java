package com.rodrigues.onepiecerestapi.services;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.character.ExposedCharacterDTO;
import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;
import com.rodrigues.onepiecerestapi.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repository;
    private final CrewService service;

    public CharacterService(CharacterRepository repository, CrewService service) {
        this.repository = repository;
        this.service = service;
    }

    private boolean checkData(CharacterDTO data) {
        return data == null || data.getName() == null || data.getName().isEmpty();
    }

    private boolean checkId(long id) {
        return id <= 0;
    }

    public List<ExposedCharacterDTO> findAll() {
        var list = repository.findAll();

        return list.stream().map(ExposedCharacterDTO::new).toList();
    }

    public ExposedCharacterDTO findById(long id) {
        if(checkId(id)) throw new IllegalArgumentException("Invalid id");

        var obj = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No records for id " + id)
        );

        return new ExposedCharacterDTO(obj);
    }


    public ExposedCharacterDTO create(CharacterDTO data) {
        if(checkData(data)) throw new IllegalArgumentException("Invalid data");

        Characters obj = repository.save(new Characters(data));

        if (data.getCrewId() > 0) {
            var crew = service.addMember(data.getCrewId(), obj);
            obj.setCrew(crew);
            Characters saved = repository.save(obj);

            CrewDTO dto = new CrewDTO(crew);
            return new ExposedCharacterDTO(saved, dto);
        }

        return new ExposedCharacterDTO(obj);
    }

    public ExposedCharacterDTO update(CharacterDTO data) {
        if(checkId(data.getId())) throw new IllegalArgumentException("Invalid id");
        if(checkData(data)) throw new IllegalArgumentException("Invalid data");

        Characters obj = repository.findById(data.getId()).orElse(null);
        if (obj != null) {
            obj.setName(data.getName());
            obj.setAge(data.getAge());
            obj.setDescription(data.getDescription());
            obj.setAbilities(data.getAbilities());
            obj.setRole(data.getRole());

            if (data.getCrewId() <= 0) {
                service.removeMember(data.getCrewId(), obj);
            }

            repository.save(obj);

            return new ExposedCharacterDTO(obj);
        }


        return null;
    }


    public void delete(long id) {
        repository.deleteById(id);
    }

}
