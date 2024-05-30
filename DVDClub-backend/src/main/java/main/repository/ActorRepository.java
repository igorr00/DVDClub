package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository <Actor, Long> {

}
