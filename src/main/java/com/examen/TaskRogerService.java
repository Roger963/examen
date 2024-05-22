package com.examen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.transaction.annotation.Propagation;

@Service
public class TaskRogerService {

    public TaskRogerRepository taskRogerRepository;

    public TaskRogerService(TaskRogerRepository taskRogerRepository) {
        this.taskRogerRepository = taskRogerRepository;
    }

    @Transactional(readOnly = true)
    public Page<TaskRogerDTO> findAllPaged(Pageable pageable) {
        Page<TaskRoger> list = taskRogerRepository.findAll(pageable);
        return list.map(TaskRogerDTO::new);
    }

    @Transactional
    public TaskRogerDTO insert(TaskRogerDTO taskRogerDTO) {
        TaskRoger entity = new TaskRoger();
        entity.setName(taskRogerDTO.getName());
        entity.setNumber(taskRogerDTO.getNumber());
        entity.setActive(taskRogerDTO.getActive());
        entity = taskRogerRepository.save(entity);
        return new TaskRogerDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String name) {
        taskRogerRepository.deleteByName(name);
    }
}

