package com.nupurjaiswal.marketplace.service;

import com.nupurjaiswal.marketplace.domain.Bid;
import com.nupurjaiswal.marketplace.domain.Project;
import com.nupurjaiswal.marketplace.exception.MarketplaceException;
import com.nupurjaiswal.marketplace.repository.BidRepository;
import com.nupurjaiswal.marketplace.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@Service
public class BidServiceImpl implements BidService{

    BidRepository bidRepository;
    ProjectRepository projectRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository, ProjectRepository projectRepository) {
        this.bidRepository = bidRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Bid> getBidById(Long id) {
        Optional<Bid> bid = bidRepository.findById(id);
        return bid;
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }

    @Override
    public void saveBid(Long projectId, @RequestBody Bid bid) {
        //Check if the project is present
        if (projectRepository.findById(projectId).isPresent()) {

            Project project = projectRepository.findById(projectId).get();

            Date deadline = projectRepository.findById(projectId).get().getDeadline();

            //Check if the project deadline is in the future
            if (deadline.after(new Date())) {
                //Check if buyer id is present or not
                if (bidRepository.findByBuyerId(bid.getBuyerId()) == null) {
                    //Check if the Project's minBid value is NaN
                    if (Double.isNaN(project.getMinBid())){
                        saveBid(projectId, bid, project);
                    }else if(bid.getBid() < project.getMinBid()){
                        saveBid(projectId, bid, project);
                    }else {
                        throw new MarketplaceException("Please enter the bid less than the current minimum bid: " + project.getMinBid());
                    }
                }else{
                    //Update the old bid value with the new one. NOTE: new value should be less than old value
                    Bid savedBid = bidRepository.findByBuyerId(bid.getBuyerId());
                    if(bid.getBid() < project.getMinBid()){
                        savedBid.setBid(bid.getBid());
                        bidRepository.save(savedBid);
                        calculateMinimumBid(project);
                    }else {
                        throw new MarketplaceException("Please enter the bid less than the current minimum bid: " + project.getMinBid());
                    }

                }
            } else {
                throw new MarketplaceException("Deadline has already been passed for projectId: " + projectId);
            }
        } else {
            throw new MarketplaceException("Project id is invalid. Please enter correct project id.");
        }
    }

    private void saveBid(Long projectId, @RequestBody Bid bid, Project project) {
        if (bid.getBid() <= project.getMaxBudget()) {
            project.setMinBid(bid.getBid());
            projectRepository.save(project);
            bid.setProject(projectRepository.findById(projectId).get());
            bidRepository.save(bid);

            calculateMinimumBid(project);
        } else {
            throw new MarketplaceException("Please enter the bid less than or equal to the project maximum budget: " + project.getMaxBudget());
        }
    }

    private void calculateMinimumBid(Project project) {
        List<Bid> list = project.getAllBids();

        HashSet<Double> hashSet = new HashSet<>();
        Double value;
        for (int i = 0; i < list.size(); i++) {
            value = list.get(i).getBid();
            if (value != null) {
                hashSet.add(value);
            }

        }
        if (!hashSet.isEmpty()) {
            Object obj = Collections.min(hashSet);
            project.setMinBid(new Double(obj.toString()));
            projectRepository.save(project);
        }
    }





}
