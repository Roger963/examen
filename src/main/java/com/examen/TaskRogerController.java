package com.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/api/v1/roger")
public class TaskRogerController {
    @Autowired
    private TaskRogerService taskRogerService;


    @GetMapping("/all")
    public ResponseEntity<Page<TaskRogerDTO>> findAll(Pageable pageable) {
        Page<TaskRogerDTO> list = taskRogerService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<TaskRogerDTO> insert(@RequestBody TaskRogerDTO taskRogerDTO) {
        taskRogerDTO = taskRogerService.insert(taskRogerDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskRogerDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(taskRogerDTO);

    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> delete(@PathVariable String name) {
        taskRogerService.delete(name);
        return ResponseEntity.noContent().build();
    }
}
