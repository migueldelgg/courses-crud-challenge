package br.com.migueldelgado.cursos_crud.modules.user.useCase;

import br.com.migueldelgado.cursos_crud.exceptions.UserAlreadyExistException;
import br.com.migueldelgado.cursos_crud.exceptions.UserNotFoundException;
import br.com.migueldelgado.cursos_crud.modules.user.entities.UserEntity;
import br.com.migueldelgado.cursos_crud.modules.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity findByIdOrThrowBadRequestException(Long id) {
        return userRepository.findById(id).orElseThrow(()
                -> new UserNotFoundException()
        );
    }

    public UserEntity execute(UserEntity user) {
        for (UserEntity existingUser : userRepository.findAll()) {
            if (user.getUsername().equals(existingUser.getUsername()) || user.getEmail().equals(existingUser.getEmail())) {
                throw new UserAlreadyExistException();
            }
        }
        var password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }






}
