package br.com.migueldelgado.cursos_crud.modules.user.useCase;


import br.com.migueldelgado.cursos_crud.exceptions.UserNotFoundException;
import br.com.migueldelgado.cursos_crud.modules.user.dto.AuthUserDTO;
import br.com.migueldelgado.cursos_crud.modules.user.dto.AuthUserResponseDTO;
import br.com.migueldelgado.cursos_crud.modules.user.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthUserUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthUserResponseDTO execute(AuthUserDTO authUserDTO) throws AuthenticationException {

        var user = this.userRepository.findByUsername(authUserDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UserNotFoundException("Username/Password incorrect");
                }
        );

        //verificar a senha da requisicao bate com a senha do banco de dados
        var passwordMatches = passwordEncoder
                .matches(authUserDTO.getPassword(), user.getPassword()); // A primeira senha é a nao criptografada | A  segunda senha é a senha criptografada do BD

        // Se nao for igual -> lancar erro
        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        // Se for igual -> Gerar token

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));

        var token = JWT.create()
                .withIssuer("courses_visualize_api")
                .withSubject(user.getId().toString())
                .withClaim("roles", Arrays.asList("USUARIO"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        var authUserResponseDTO = AuthUserResponseDTO.builder()
                .acces_token(token)
                .expires_in(expiresIn.toEpochMilli())
                .build();

        return authUserResponseDTO;
    }

}
