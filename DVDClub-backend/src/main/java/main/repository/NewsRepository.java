package main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.News;

@Repository
public interface NewsRepository extends JpaRepository <News, Long> {
	
	Optional<News> findById(Long id);
}
