package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Dvd;

@Repository
public interface DvdRepository extends JpaRepository <Dvd, Long> {

}
