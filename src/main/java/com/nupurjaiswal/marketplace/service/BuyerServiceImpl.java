package com.nupurjaiswal.marketplace.service;

import com.nupurjaiswal.marketplace.domain.Buyer;
import com.nupurjaiswal.marketplace.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService{

    BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> getAllBuyers() {
       return buyerRepository.findAll();
    }

    @Override
    public Optional<Buyer> getBuyerById(Long id) {
        Optional<Buyer> buyer = buyerRepository.findById(id);
        return buyer;
    }

    @Override
    public void saveBuyer(Buyer buyer) {
        buyerRepository.save(buyer);
    }
}
