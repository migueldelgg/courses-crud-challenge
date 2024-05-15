package br.com.migueldelgado.cursos_crud.modules.course.controller;


import br.com.migueldelgado.cursos_crud.modules.course.dto.CourseDTO;
import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import br.com.migueldelgado.cursos_crud.modules.course.entities.EnumActive;
import br.com.migueldelgado.cursos_crud.modules.course.useCase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {

        return new ResponseEntity<>(courseUseCase.execute(courseEntity), HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<List<CourseDTO>> list() {

        return ResponseEntity.ok(courseUseCase.listAll());

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> replace(@Valid @RequestBody CourseDTO courseDTO, @PathVariable Long id) {

        courseUseCase.replace(courseDTO, id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        courseUseCase.delete(id);

        return ResponseEntity.ok().body("Curso deletado com sucesso.");
    }

    @PatchMapping(path = "/{id}/{enumActive}")
    public Object patchUpdate(@PathVariable Long id, @PathVariable EnumActive enumActive) {

        courseUseCase.patchUpdate(id, enumActive);

        return ResponseEntity.ok().body("Campo atualizado com sucesso.");
    }

}
