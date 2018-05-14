package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
