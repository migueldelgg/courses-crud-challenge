package br.com.migueldelgado.cursos_crud.modules.course.repositories;

import br.com.migueldelgado.cursos_crud.modules.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
