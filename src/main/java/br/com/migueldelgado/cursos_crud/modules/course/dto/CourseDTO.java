package br.com.migueldelgado.cursos_crud.modules.course.dto;

import br.com.migueldelgado.cursos_crud.modules.course.entities.EnumActive;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class CourseDTO {

    String name;
    String category;
    EnumActive active;

}
