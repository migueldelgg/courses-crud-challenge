package br.com.migueldelgado.cursos_crud.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AuthUserDTO {

    private String username;
    private String password;

}
