package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Buyer;

import java.util.List;
import java.util.Optional;



public interface BuyerService {

    Optional<Buyer> getBuyerById(Long id);
    List<Buyer> getAllBuyers();
    void saveBuyer(Buyer buyer);


}
