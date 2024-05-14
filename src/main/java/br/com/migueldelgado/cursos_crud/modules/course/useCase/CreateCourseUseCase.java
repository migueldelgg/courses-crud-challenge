package br.com.migueldelgado.cursos_crud.modules.course.useCase;

import br.com.migueldelgado.cursos_crud.modules.course.repositories.CourseRepository;
import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity){

        return courseRepository.save(courseEntity);
    }

}
