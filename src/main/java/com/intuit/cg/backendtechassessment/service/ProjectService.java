package com.intuit.cg.backendtechassessment.service;

import com.intuit.cg.backendtechassessment.domain.Project;

import java.util.List;
import java.util.Optional;


public interface ProjectService {

    Optional<Project> getProjectById(Long id);
    List<Project> getAllProjects();
    void saveProject(Project project);


}
