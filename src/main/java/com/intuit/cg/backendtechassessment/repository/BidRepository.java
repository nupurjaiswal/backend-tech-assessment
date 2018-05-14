package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.domain.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BidRepository extends JpaRepository<Bid, Long> {
    Bid findByBuyerId(Long buyerId);
}
