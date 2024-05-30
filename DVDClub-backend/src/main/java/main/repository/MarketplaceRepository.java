package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Marketplace;

@Repository
public interface MarketplaceRepository extends JpaRepository <Marketplace, Long> {

}
