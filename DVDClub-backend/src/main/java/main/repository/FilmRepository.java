package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Film;

@Repository
public interface FilmRepository extends JpaRepository <Film, Long> {

}
