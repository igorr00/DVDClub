package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Rent;

@Repository
public interface RentRepository extends JpaRepository <Rent, Long> {

}
