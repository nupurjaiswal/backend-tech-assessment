package com.nupurjaiswal.marketplace.repository;

import com.nupurjaiswal.marketplace.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
