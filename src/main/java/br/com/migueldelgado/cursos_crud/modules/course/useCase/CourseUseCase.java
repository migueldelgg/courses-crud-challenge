package br.com.migueldelgado.cursos_crud.modules.course.useCase;

import br.com.migueldelgado.cursos_crud.modules.course.dto.CourseDTO;
import br.com.migueldelgado.cursos_crud.modules.course.repositories.CourseRepository;
import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class CourseUseCase {

    @Autowired
    CourseRepository courseRepository;

    CourseDTO courseDTO;

    public CourseEntity execute(CourseEntity courseEntity){

        if(!courseEntity.getName().isEmpty() || !courseEntity.getCategory().isEmpty()) {
            return courseRepository.save(courseEntity);
        }
        throw new IllegalArgumentException("O curso deve ter um nome e uma categoria!");

    }

    public List<CourseDTO> listAll(){

        List<CourseDTO> list = new ArrayList<>();

        for (CourseEntity i : courseRepository.findAll()){

            var course = courseDTO.builder().name(i.getName()).category(i.getCategory())
                    .active(i.getActive()).build();
            
            list.add(course);
        }

        return list;
    }

    public void replace(CourseDTO courseDTO, UUID id){

        courseRepository.findById(id).orElseThrow(()
            -> new
        );

    }

}
