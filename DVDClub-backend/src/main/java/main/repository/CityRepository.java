package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.City;

@Repository
public interface CityRepository extends JpaRepository <City, Long> {

}
