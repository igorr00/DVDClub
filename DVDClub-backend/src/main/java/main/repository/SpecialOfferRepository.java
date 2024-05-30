package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.SpecialOffer;

@Repository
public interface SpecialOfferRepository extends JpaRepository <SpecialOffer, Long> {

}
