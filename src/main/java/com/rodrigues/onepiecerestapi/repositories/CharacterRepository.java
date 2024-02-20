package com.rodrigues.onepiecerestapi.repositories;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {

    public List<Characters> findByCrewId(Long crewId);
}
