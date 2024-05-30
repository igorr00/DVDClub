package main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import main.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository <Purchase, Long> {

}
