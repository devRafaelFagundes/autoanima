package com.ieka.autoanima.repository;

import com.ieka.autoanima.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
