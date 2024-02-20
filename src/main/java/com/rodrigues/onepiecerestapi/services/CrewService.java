package com.rodrigues.onepiecerestapi.services;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import com.rodrigues.onepiecerestapi.model.crew.Crew;
import com.rodrigues.onepiecerestapi.model.crew.CrewDTO;
import com.rodrigues.onepiecerestapi.repositories.CrewRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewService {
    private final CrewRepository repository;
    private final ModelMapper mapper;

    public CrewService(CrewRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private boolean checkData(CrewDTO crew) {
        return crew.getName() == null || crew.getName().isEmpty();
    }

    private boolean checkId(long id) {
        return id <= 0;
    }

    public List<CrewDTO> findAll() {
        var list = repository.findAll();

        return list.stream().map(
                obj -> mapper.map(obj, CrewDTO.class)
        ).toList();
    }

    public CrewDTO findById(long id) {
        if(checkId(id)) throw new IllegalArgumentException("Invalid id");

        var obj = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No records found for this ID" + id)
        );

        return mapper.map(obj, CrewDTO.class);
    }


    public CrewDTO create(CrewDTO crew) {
        if(checkData(crew)) throw new IllegalArgumentException("Invalid data");

        Crew obj = new Crew(crew);

        repository.save(obj);

        crew.setId(obj.getId());

        return crew;
    }

    public CrewDTO update(CrewDTO crew) {
        if(checkData(crew)) throw new IllegalArgumentException("Invalid data");
        if(checkId(crew.getId())) throw new IllegalArgumentException("Invalid id");

        var obj = repository.findById(crew.getId()).orElseThrow(
                () -> new IllegalArgumentException("No records found for this ID" + crew.getId())
        );

        obj.setName(crew.getName());

        repository.save(obj);

        return mapper.map(obj, CrewDTO.class);
    }

    public void delete(long id) {
        if(checkId(id)) throw new IllegalArgumentException("Invalid id");

        repository.deleteById(id);
    }


    public Crew addMember(long id, Characters member) {
        Crew crew = repository.findById(id).orElse(null);

        if (crew != null) {
            crew.getMembers().add(member);
            return repository.save(crew);
        }

        return null;
    }
    public void removeMember(long id, Characters member) {
        var crew = repository.findById(id).orElse(null);
        if (crew != null) {
            crew.getMembers().remove(member);
            repository.save(crew);
        }
    }
}
