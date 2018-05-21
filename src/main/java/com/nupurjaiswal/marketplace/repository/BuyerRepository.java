package com.nupurjaiswal.marketplace.repository;

import com.nupurjaiswal.marketplace.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

}
