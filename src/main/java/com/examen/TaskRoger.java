package com.examen;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Data
@Table(name = "tb_roger")
public class TaskRoger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant data;
    private Integer number;
    private Boolean active;

    @PrePersist
    public void prePersist() {
        data = Instant.now();
    }
}
