package br.com.migueldelgado.cursos_crud.modules.course.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.UUID;

@Data
@Entity(name = "course")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @NotBlank
    @Length(min = 2, max = 35)
    private String name;

    @NotBlank
    @Length(min = 5, max = 30)
    private String category;

    @Enumerated(EnumType.STRING)
    private EnumActive active;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

}
