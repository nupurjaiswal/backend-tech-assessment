package com.nupurjaiswal.marketplace.service;

import com.nupurjaiswal.marketplace.domain.Buyer;

import java.util.List;
import java.util.Optional;



public interface BuyerService {

    Optional<Buyer> getBuyerById(Long id);
    List<Buyer> getAllBuyers();
    void saveBuyer(Buyer buyer);


}
