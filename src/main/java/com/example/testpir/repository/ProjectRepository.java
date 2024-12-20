package com.example.testpir.repository;

import com.example.testpir.entity.Project;
import com.example.testpir.entity.ProjectStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
  List<Project> findByStatus(ProjectStatus status);
}
