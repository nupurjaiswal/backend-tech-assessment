package com.intuit.cg.backendtechassessment.controller;

import com.intuit.cg.backendtechassessment.domain.Bid;
import com.intuit.cg.backendtechassessment.domain.Buyer;
import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.domain.Seller;
import com.intuit.cg.backendtechassessment.service.BidService;
import com.intuit.cg.backendtechassessment.service.BuyerService;
import com.intuit.cg.backendtechassessment.service.ProjectService;
import com.intuit.cg.backendtechassessment.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class MarketplaceController {


    private SellerService sellerService;
    private BuyerService buyerService;
    private ProjectService projectService;
    private BidService bidService;

    @Autowired
    public MarketplaceController(SellerService sellerService, BuyerService buyerService, ProjectService projectService, BidService bidService) {
        this.sellerService = sellerService;
        this.buyerService = buyerService;
        this.projectService = projectService;
        this.bidService = bidService;
    }

    //-------------------------- GET all sellers --------------------------//
    @GetMapping("/sellers")
    public List<Seller> getSellers() {
        return sellerService.getAllSellers();
    }

    //-------------------------- GET seller by id --------------------------//
    @GetMapping("/sellers/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable("id") Long id) {
        Optional<Seller> seller = sellerService.getSellerById(id);
        if (!seller.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(seller.get(), HttpStatus.OK);
        }
    }

    //-------------------------- POST seller --------------------------//
    @PostMapping("/sellers")
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        sellerService.saveSeller(seller);
        return new ResponseEntity<>(seller,HttpStatus.CREATED);
    }

    //-------------------------- GET all buyers --------------------------//
    @GetMapping("/buyers")
    public List<Buyer> getBuyers() {
        return buyerService.getAllBuyers();
    }

    //-------------------------- GET buyer by id --------------------------//
    @GetMapping("/buyers/{id}")
    public ResponseEntity<Buyer> getBuyer(@PathVariable("id") Long id) {
        Optional<Buyer> buyer = buyerService.getBuyerById(id);
        if (!buyer.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(buyer.get(), HttpStatus.OK);
        }
    }

    //-------------------------- POST buyer --------------------------//
    @PostMapping("/buyers")
    public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
        buyerService.saveBuyer(buyer);
        return new ResponseEntity<>(buyer,HttpStatus.CREATED);
    }

    //-------------------------- GET all projects --------------------------//
    @GetMapping("/projects")
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    //-------------------------- GET project by id --------------------------//
    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") Long id) {
        Optional<Project> project = projectService.getProjectById(id);
        if (!project.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(project.get(), HttpStatus.OK);
        }
    }

    //-------------------------- POST project --------------------------//
    @PostMapping("/projects")
    public ResponseEntity<String> createProject(@Valid @RequestBody Project project) {
        projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //-------------------------- GET all bids --------------------------//
    @GetMapping("/bids")
    public List<Bid> getBids() {
        return bidService.getAllBids();
    }

    //-------------------------- GET bid by id --------------------------//
    @GetMapping("/bids/{id}")
    public ResponseEntity<Bid> getBid(@PathVariable("id") Long id) {
        Optional<Bid> bid = bidService.getBidById(id);
        if (!bid.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bid.get(), HttpStatus.OK);
        }
    }

    //-------------------------- POST bid --------------------------//
    @PostMapping("/projects/{projectId}/bids")
    public ResponseEntity<String> createBid(@PathVariable("projectId") Long projectId, @Valid @RequestBody Bid bid) {
        bidService.saveBid(projectId, bid);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
