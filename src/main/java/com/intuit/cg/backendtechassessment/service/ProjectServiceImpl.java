package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Project;
import com.intuit.cg.backendtechassessment.domain.Seller;
import com.intuit.cg.backendtechassessment.exception.MarketplaceException;
import com.intuit.cg.backendtechassessment.repository.ProjectRepository;
import com.intuit.cg.backendtechassessment.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    ProjectRepository projectRepository;
    SellerRepository sellerRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, SellerRepository sellerRepository) {
        this.projectRepository = projectRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        return project;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public void saveProject(Project project) {
        Optional<Seller> findSeller = sellerRepository.findById(project.getSellerId());
        if (!findSeller.isPresent()) {
            throw new MarketplaceException("Please POST the seller entry in /sellers endpoint before adding the project.");
        } else{
            if(project.getDeadline().after(new Date())){
                projectRepository.saveAndFlush(project);
            }else{
                throw new MarketplaceException("Please enter the deadline of the Project greater than today's date.");
            }
        }
    }

  }
