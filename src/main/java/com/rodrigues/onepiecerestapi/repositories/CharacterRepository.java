package com.rodrigues.onepiecerestapi.repositories;

import com.rodrigues.onepiecerestapi.model.character.Characters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Characters, Long> {
}
