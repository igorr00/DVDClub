package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Director;

@Repository
public interface DirectorRepository extends JpaRepository <Director, Long> {

}
