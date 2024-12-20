package com.example.testpir.dto;

public class ProjectSectionDTO {
  private Long id;
  private String section;
  private String type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSection() {
    return section;
  }

  public void setSection(String section) {
    this.section = section;
  }

  public String getType() { // Добавлен геттер для типа
    return type;
  }

  public void setType(String type) { // Добавлен сеттер для типа
    this.type = type;
  }
}
