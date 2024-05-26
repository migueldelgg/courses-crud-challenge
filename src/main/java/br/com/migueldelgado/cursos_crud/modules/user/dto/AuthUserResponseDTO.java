package br.com.migueldelgado.cursos_crud.modules.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponseDTO {

    private String acces_token;
    private Long expires_in;

}
