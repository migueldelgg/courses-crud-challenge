package br.com.migueldelgado.cursos_crud.modules.user.repositories;

import br.com.migueldelgado.cursos_crud.modules.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
