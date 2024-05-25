package br.com.migueldelgado.cursos_crud.modules.user.controller;

import br.com.migueldelgado.cursos_crud.modules.user.dto.AuthUserDTO;
import br.com.migueldelgado.cursos_crud.modules.user.useCase.AuthUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
public class AuthUserController {

    @Autowired
    private AuthUserUseCase authUserUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody AuthUserDTO authUserDTO) {
        try {
            var token = this.authUserUseCase.execute(authUserDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }


}
