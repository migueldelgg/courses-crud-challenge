package br.com.migueldelgado.cursos_crud.modules.course.controller;


import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import br.com.migueldelgado.cursos_crud.modules.course.useCase.CreateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CreateCourseUseCase createCourseUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> create (@Valid @RequestBody CourseEntity courseEntity) {
        return new ResponseEntity<>(createCourseUseCase.execute(courseEntity), HttpStatus.CREATED);
    }

}
