package com.rodrigues.onepiecerestapi.repositories;

import com.rodrigues.onepiecerestapi.model.crew.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {
}
