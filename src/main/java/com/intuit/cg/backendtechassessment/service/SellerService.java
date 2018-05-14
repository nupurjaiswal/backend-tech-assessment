package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Seller;

import java.util.List;
import java.util.Optional;



public interface SellerService {

    Optional<Seller> getSellerById(Long id);
    List<Seller> getAllSellers();
    void saveSeller(Seller seller);

}
