package com.examen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Servlet;
import org.springframework.http.ResponseEntity;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/roger")
public class TaskRogerController {
    @Autowired
    private TaskRogerService taskRogerService;



    @PostMapping
    public ResponseEntity<TaskRogerDTO> insert(@RequestBody TaskRogerDTO taskRogerDTO) {
        taskRogerDTO = taskRogerService.insert(taskRogerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskRogerDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(taskRogerDTO);

    }
}
