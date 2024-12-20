package com.example.testpir.service;

import com.example.testpir.dto.ProjectDTO;
import com.example.testpir.dto.mapper.ProjectMapper;
import com.example.testpir.entity.Project;
import com.example.testpir.entity.ProjectSection;
import com.example.testpir.entity.ProjectStatus;
import com.example.testpir.entity.SectionType;
import com.example.testpir.repository.ProjectRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  public List<ProjectDTO> getAllProjects() {
    return projectRepository.findAll().stream()
        .map(ProjectMapper::toDto)
        .collect(Collectors.toList());
  }

  public ProjectDTO getProjectById(Long id) {
    Project project = projectRepository.findById(id).orElseThrow();
    return ProjectMapper.toDto(project);
  }

  public ProjectDTO createProject(ProjectDTO projectDTO) {
    Project project = ProjectMapper.toEntity(projectDTO);
    return ProjectMapper.toDto(projectRepository.save(project));
  }

  public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
    Project existingProject = projectRepository.findById(id).orElseThrow();
    existingProject.setTitle(projectDTO.getTitle());
    existingProject.setCode(projectDTO.getCode());
    existingProject.setStartDate(projectDTO.getStartDate());
    existingProject.setEndDate(projectDTO.getEndDate());
    existingProject.setStatus(ProjectStatus.valueOf(projectDTO.getStatus()));

    existingProject.getSections().clear();

    existingProject.setSections(projectDTO.getSections().stream()
        .map(sectionName -> {
          ProjectSection projectSection = new ProjectSection();
          projectSection.setProject(existingProject);
          projectSection.setType(SectionType.valueOf(String.valueOf(sectionName)));
          return projectSection;
        })
        .collect(Collectors.toSet()));

    return ProjectMapper.toDto(projectRepository.save(existingProject));
  }

  public List<ProjectDTO> getProjectsByStatus(String status) {
    ProjectStatus projectStatus = ProjectStatus.valueOf(status.toUpperCase());
    return projectRepository.findByStatus(projectStatus).stream()
        .map(ProjectMapper::toDto)
        .collect(Collectors.toList());
  }

  public void deleteProject(Long id) {
    projectRepository.deleteById(id);
  }
}