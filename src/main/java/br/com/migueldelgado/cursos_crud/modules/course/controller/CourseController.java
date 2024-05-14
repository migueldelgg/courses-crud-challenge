package br.com.migueldelgado.cursos_crud.modules.course.controller;


import br.com.migueldelgado.cursos_crud.modules.course.dto.CourseDTO;
import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import br.com.migueldelgado.cursos_crud.modules.course.useCase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create (@Valid @RequestBody CourseEntity courseEntity) {
        return new ResponseEntity<>(courseUseCase.execute(courseEntity), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> list(){
        return ResponseEntity.ok(courseUseCase.listAll());
    }

}
