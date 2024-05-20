package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.FilmStudio;

@Repository
public interface FilmStudioRepository extends JpaRepository<FilmStudio, Long> {

}
