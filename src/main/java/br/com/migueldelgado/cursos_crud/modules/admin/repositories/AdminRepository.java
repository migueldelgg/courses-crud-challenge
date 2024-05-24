package br.com.migueldelgado.cursos_crud.modules.admin.repositories;

import br.com.migueldelgado.cursos_crud.modules.admin.entities.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {


}
