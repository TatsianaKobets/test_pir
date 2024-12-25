package com.example.testpir.service;

import com.example.testpir.dto.ProjectDTO;
import java.util.List;

public interface ProjectService {

  List<ProjectDTO> getAllProjects();

  ProjectDTO getProjectById(Long id);

  ProjectDTO createProject(ProjectDTO projectDTO);

  ProjectDTO updateProject(Long id, ProjectDTO projectDTO);

  List<ProjectDTO> getProjectsByStatus(String status);

  void deleteProject(Long id);
}
