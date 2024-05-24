package br.com.migueldelgado.cursos_crud.modules.user.userRepositories;

import br.com.migueldelgado.cursos_crud.modules.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
