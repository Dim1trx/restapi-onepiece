package com.rodrigues.onepiecerestapi.services;

import com.rodrigues.onepiecerestapi.model.character.CharacterDTO;
import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.repositories.CharacterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository repository;
    private final CrewService service;
    private final ModelMapper mapper;
    public CharacterService(CharacterRepository repository, CrewService service, ModelMapper mapper) {
        this.repository = repository;
        this.service = service;
        this.mapper = mapper;
    }

    private boolean checkData(CharacterDTO data) {
        return data == null || data.getName() == null || data.getName().isEmpty();
    }

    private boolean checkId(long id) {
        return id <= 0;
    }

    public List<CharacterDTO> findAll() {
        var list = repository.findAll();

        return list.stream().map(
                obj -> mapper.map(obj, CharacterDTO.class)
        ).toList();
    }

    public List<CharacterDTO> findByCrewId(Long id) {
        return repository.findByCrewId(id).stream().map(
                obj -> mapper.map(obj, CharacterDTO.class)
        ).toList();
    }

    public CharacterDTO findById(long id) {
        if(checkId(id)) throw new IllegalArgumentException("Invalid id");

        var obj = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No records for id " + id)
        );

        return mapper.map(obj, CharacterDTO.class);
    }

    public CharacterDTO create(CharacterDTO data) {
        if(checkData(data)) throw new IllegalArgumentException("Invalid data");

        Characters obj = repository.save(mapper.map(data, Characters.class));

        if (data.getCrewId() > 0) {
            var crew = service.addMember(data.getCrewId(), obj);
            obj.setCrew(crew);
            repository.save(obj);
        }

        return mapper.map(obj, CharacterDTO.class);
    }

    public CharacterDTO update(CharacterDTO data) {
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

            return mapper.map(obj, CharacterDTO.class);
        }

        return null;
    }


    public void delete(long id) {
        repository.deleteById(id);
    }
}
