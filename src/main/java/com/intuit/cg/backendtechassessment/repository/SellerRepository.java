package com.intuit.cg.backendtechassessment.repository;

import com.intuit.cg.backendtechassessment.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
