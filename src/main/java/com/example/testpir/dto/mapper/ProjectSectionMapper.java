package com.example.testpir.dto.mapper;

import com.example.testpir.dto.ProjectSectionDTO;
import com.example.testpir.entity.ProjectSection;
import com.example.testpir.entity.SectionType;

public class ProjectSectionMapper {

  public static ProjectSectionDTO toDto(ProjectSection projectSection) {
    ProjectSectionDTO dto = new ProjectSectionDTO();
    dto.setId(projectSection.getId());
    dto.setSection(projectSection.getName()); // Изменено на getName()
    dto.setType(projectSection.getType().name()); // Добавлено для типа
    return dto;
  }

  public static ProjectSection toEntity(ProjectSectionDTO dto) {
    ProjectSection projectSection = new ProjectSection();
    projectSection.setId(dto.getId());
    projectSection.setName(dto.getSection()); // Изменено на setName()
    projectSection.setType(SectionType.valueOf(dto.getType())); // Добавлено для типа
    return projectSection;
  }
}
