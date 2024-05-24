package br.com.migueldelgado.cursos_crud.modules.admin.repositories;

import br.com.migueldelgado.cursos_crud.modules.admin.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {


}
