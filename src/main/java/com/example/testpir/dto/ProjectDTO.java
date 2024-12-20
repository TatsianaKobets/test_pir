package com.example.testpir.dto;

import java.time.LocalDate;
import java.util.List;

public class ProjectDTO {
  private Long id;
  private String title;
  private String code;
  private LocalDate startDate;
  private LocalDate endDate;
  private String status;
  private List<ProjectSectionDTO> sections;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<ProjectSectionDTO> getSections() { // Изменено здесь
    return sections;
  }

  public void setSections(List<ProjectSectionDTO> sections) { // Изменено здесь
    this.sections = sections;
  }
}