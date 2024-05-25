package br.com.migueldelgado.cursos_crud.modules.user.controller;


import br.com.migueldelgado.cursos_crud.modules.admin.entities.AdminEntity;
import br.com.migueldelgado.cursos_crud.modules.admin.useCase.AdminUseCase;
import br.com.migueldelgado.cursos_crud.modules.user.entities.UserEntity;
import br.com.migueldelgado.cursos_crud.modules.user.useCase.UserUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserUseCase userUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody UserEntity userEntity){
        try {
            var result = userUseCase.execute(userEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
