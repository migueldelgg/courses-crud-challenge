package br.com.migueldelgado.cursos_crud.modules.admin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class PublicAdminInfoDTO {


    @NotBlank
    private String name;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

}
