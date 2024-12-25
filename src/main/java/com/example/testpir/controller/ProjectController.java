package com.example.testpir.controller;

import com.example.testpir.dto.ProjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public interface ProjectController {

  @GetMapping
  ResponseEntity<List<ProjectDTO>> getAllProjects();

  @GetMapping("/{id}")
  ResponseEntity<ProjectDTO> getProjectById(@PathVariable Long id);

  @PostMapping
  ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO);

  @PutMapping("/{id}")
  ResponseEntity<ProjectDTO> updateProject(@PathVariable Long id, @RequestBody ProjectDTO projectDTO);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteProject(@PathVariable Long id);

  @GetMapping("/status/{status}")
  ResponseEntity<List<ProjectDTO>> getProjectsByStatus(@PathVariable String status);
}
