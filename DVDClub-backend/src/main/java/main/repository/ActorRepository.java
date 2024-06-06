package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Long> {
	
	Optional<Actor> findById(Long id);
}
