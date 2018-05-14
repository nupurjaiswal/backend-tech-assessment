package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Bid;

import java.util.List;
import java.util.Optional;


public interface BidService {

    Optional<Bid> getBidById(Long id);
    List<Bid> getAllBids();
    void saveBid(Long projectId, Bid bid);

}
