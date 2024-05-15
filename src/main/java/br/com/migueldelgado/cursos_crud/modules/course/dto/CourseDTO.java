package br.com.migueldelgado.cursos_crud.modules.course.dto;

import br.com.migueldelgado.cursos_crud.modules.course.entities.EnumActive;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CourseDTO {

    @NotBlank
    @Length(min = 2, max = 35)
    private String name;

    @NotBlank
    @Length(min = 5, max = 30)
    private String category;

    @Enumerated(EnumType.STRING)
    private EnumActive active;

}
