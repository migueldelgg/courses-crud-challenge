package br.com.migueldelgado.cursos_crud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /**
     * Define a cadeia de filtros de segurança para a aplicação.
     * Este método configura as definições de segurança HTTP, como a desativação da proteção CSRF.
     * O método é anotado com @Bean para indicar que ele retorna um bean que será gerenciado pelo container do Spring.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/user/").permitAll();
                    auth.anyRequest().authenticated();
                        });

        return http.build();
    }

}
