package br.com.migueldelgado.cursos_crud.modules.admin.useCase;

import br.com.migueldelgado.cursos_crud.exceptions.AdminNotFoundException;
import br.com.migueldelgado.cursos_crud.exceptions.UserAlreadyExistException;
import br.com.migueldelgado.cursos_crud.modules.admin.dto.AdminDTO;
import br.com.migueldelgado.cursos_crud.modules.admin.dto.PublicAdminInfoDTO;
import br.com.migueldelgado.cursos_crud.modules.admin.entities.AdminEntity;
import br.com.migueldelgado.cursos_crud.modules.admin.repositories.AdminRepository;
import br.com.migueldelgado.cursos_crud.modules.user.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminUseCase {

    private AdminDTO adminDTO;

    private PublicAdminInfoDTO publicAdminInfoDTO;

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity findByIdOrThrowBadRequestException(Long id) {
        return adminRepository.findById(id).orElseThrow(()
                -> new AdminNotFoundException()
        );
    }

    public PublicAdminInfoDTO findByIdUsingDTO(Long id){
        var admin = findByIdOrThrowBadRequestException(id);

        return PublicAdminInfoDTO.builder().name(admin.getName()).email(admin.getEmail()).build();
    }

    public AdminEntity execute(AdminEntity admin){

        for (AdminEntity existingAdmin : adminRepository.findAll()) {
            if (admin.getUsername().equals(existingAdmin.getUsername()) || admin.getEmail().equals(existingAdmin.getEmail())) {
                throw new UserAlreadyExistException();
            }
        }
        return adminRepository.save(admin);
    }

    public List<PublicAdminInfoDTO> listAll(){

        List<PublicAdminInfoDTO> list = new ArrayList<>();

        for (AdminEntity i : adminRepository.findAll()){

            var admin = PublicAdminInfoDTO.builder().name(i.getName())
                    .email(i.getEmail()).build();

            list.add(admin);
        }

        return list;
    }

    public void delete(Long id){

        var admin = findByIdOrThrowBadRequestException(id);

        adminRepository.deleteById(admin.getId());
    }

}
