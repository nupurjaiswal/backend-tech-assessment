package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Buyer;
import com.intuit.cg.backendtechassessment.repository.BuyerRepository;
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
