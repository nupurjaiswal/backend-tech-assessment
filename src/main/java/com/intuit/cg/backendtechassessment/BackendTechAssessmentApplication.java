package com.intuit.cg.backendtechassessment;

import com.intuit.cg.backendtechassessment.domain.Buyer;
import com.intuit.cg.backendtechassessment.domain.Seller;
import com.intuit.cg.backendtechassessment.repository.BuyerRepository;
import com.intuit.cg.backendtechassessment.repository.ProjectRepository;
import com.intuit.cg.backendtechassessment.repository.SellerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class BackendTechAssessmentApplication {

    private static final Logger logger = LoggerFactory.getLogger(BackendTechAssessmentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackendTechAssessmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup(SellerRepository sellerRepository, BuyerRepository buyerRepository, ProjectRepository projectRepository) {
        return (args) -> {
            sellerRepository.save(new Seller("Accenture"));
            sellerRepository.save(new Seller("Apple"));
            sellerRepository.save(new Seller("Google"));
            sellerRepository.save(new Seller("Intuit"));
            sellerRepository.save(new Seller("Upworks"));
            logger.info("Sample Seller data has been generated");
            buyerRepository.save(new Buyer("Akshay"));
            buyerRepository.save(new Buyer("Nupur"));
            buyerRepository.save(new Buyer("Parth"));
            buyerRepository.save(new Buyer("Sonu"));
            buyerRepository.save(new Buyer("Sam"));
            logger.info("Sample Buyer data has been generated");
        };
    }
}
