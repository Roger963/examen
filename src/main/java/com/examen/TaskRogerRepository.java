package com.examen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRogerRepository extends JpaRepository<TaskRoger, Long> {

    void deleteByName(String name);


}
