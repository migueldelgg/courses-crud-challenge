package br.com.migueldelgado.cursos_crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityUserFilter securityUserFilter;


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
                    auth.requestMatchers("/admin/").permitAll();
                    auth.requestMatchers("/user/auth/").permitAll();
                    auth.requestMatchers("/curso/").permitAll();
                    auth.anyRequest().authenticated();
                        })
                .addFilterBefore(securityUserFilter, BasicAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

}
