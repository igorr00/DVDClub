package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

	Optional<Genre> findById(Long id);
}
