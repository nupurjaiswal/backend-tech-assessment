package com.nupurjaiswal.marketplace.service;

import com.nupurjaiswal.marketplace.domain.Seller;

import java.util.List;
import java.util.Optional;



public interface SellerService {

    Optional<Seller> getSellerById(Long id);
    List<Seller> getAllSellers();
    void saveSeller(Seller seller);

}
