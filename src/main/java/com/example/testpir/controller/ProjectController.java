package com.example.testpir.controller;

import com.example.testpir.dto.ProjectDTO;
import com.example.testpir.service.ProjectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping
  public ResponseEntity<List<ProjectDTO>> getAllProjects() {
    List<ProjectDTO> projects = projectService.getAllProjects();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
    ProjectDTO project = projectService.getProjectById(id);
    return new ResponseEntity<>(project, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
    ProjectDTO newProject = projectService.createProject(projectDTO);
    return new ResponseEntity<>(newProject, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
    ProjectDTO updatedProject = projectService.updateProject(id, projectDTO);
    return new ResponseEntity<>(updatedProject, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteProject(@PathVariable Long id) {
    projectService.deleteProject(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<List<ProjectDTO>> getProjectsByStatus(@PathVariable String status) {
    List<ProjectDTO> projects = projectService.getProjectsByStatus(status);
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }
}