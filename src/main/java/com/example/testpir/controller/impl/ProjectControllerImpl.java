package com.example.testpir.controller.impl;

import com.example.testpir.controller.ProjectController;
import com.example.testpir.dto.ProjectDTO;
import com.example.testpir.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectControllerImpl implements ProjectController {

  @Autowired
  private ProjectServiceImpl projectServiceImpl;

  @Override
  @GetMapping
  public ResponseEntity<List<ProjectDTO>> getAllProjects() {
    List<ProjectDTO> projects = projectServiceImpl.getAllProjects();
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id) {
    ProjectDTO project = projectServiceImpl.getProjectById(id);
    return new ResponseEntity<>(project, HttpStatus.OK);
  }

  @Override
  @PostMapping
  public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {
    ProjectDTO newProject = projectServiceImpl.createProject(projectDTO);
    return new ResponseEntity<>(newProject, HttpStatus.CREATED);
  }

  @Override
  @PutMapping("/{id}")
  public ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO) {
    ProjectDTO updatedProject = projectServiceImpl.updateProject(id, projectDTO);
    return new ResponseEntity<>(updatedProject, HttpStatus.OK);
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
    projectServiceImpl.deleteProject(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  @GetMapping("/status/{status}")
  public ResponseEntity<List<ProjectDTO>> getProjectsByStatus(@PathVariable String status) {
    List<ProjectDTO> projects = projectServiceImpl.getProjectsByStatus(status);
    return new ResponseEntity<>(projects, HttpStatus.OK);
  }
}