package com.example.testpir.dto.mapper;

import com.example.testpir.dto.ProjectDTO;
import com.example.testpir.dto.ProjectSectionDTO;
import com.example.testpir.entity.Project;
import com.example.testpir.entity.ProjectSection;
import com.example.testpir.entity.ProjectStatus;
import com.example.testpir.entity.SectionType;
import java.util.stream.Collectors;

public class ProjectMapper {
  public static ProjectDTO toDto(Project project) {
    ProjectDTO dto = new ProjectDTO();
    dto.setId(project.getId());
    dto.setTitle(project.getTitle());
    dto.setCode(project.getCode());
    dto.setStartDate(project.getStartDate());
    dto.setEndDate(project.getEndDate());
    dto.setStatus(project.getStatus().name());
    dto.setSections(project.getSections().stream()
        .map(section -> {
          ProjectSectionDTO sectionDTO = new ProjectSectionDTO();
          sectionDTO.setId(section.getId());
          sectionDTO.setSection(section.getName());
          sectionDTO.setType(section.getType().name());
          return sectionDTO;
        })
        .collect(Collectors.toList()));
    return dto;
  }

  public static Project toEntity(ProjectDTO dto) {
    Project project = new Project();
    project.setId(dto.getId());
    project.setTitle(dto.getTitle());
    project.setCode(dto.getCode());
    project.setStartDate(dto.getStartDate());
    project.setEndDate(dto.getEndDate());
    project.setStatus(ProjectStatus.valueOf(dto.getStatus()));
    project.setSections(dto.getSections().stream()
        .map(sectionDTO -> {
          ProjectSection projectSection = new ProjectSection();
          projectSection.setProject(project);
          projectSection.setName(sectionDTO.getSection());
          projectSection.setType(SectionType.valueOf(sectionDTO.getType()));
          return projectSection;
        })
        .collect(Collectors.toSet()));
    return project;
  }
}