package com.nupurjaiswal.marketplace.service;

import com.nupurjaiswal.marketplace.domain.Bid;

import java.util.List;
import java.util.Optional;


public interface BidService {

    Optional<Bid> getBidById(Long id);
    List<Bid> getAllBids();
    void saveBid(Long projectId, Bid bid);

}
