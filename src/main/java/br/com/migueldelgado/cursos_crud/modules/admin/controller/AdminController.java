package br.com.migueldelgado.cursos_crud.modules.admin.controller;

import br.com.migueldelgado.cursos_crud.modules.admin.dto.PublicAdminInfoDTO;
import br.com.migueldelgado.cursos_crud.modules.admin.entities.AdminEntity;
import br.com.migueldelgado.cursos_crud.modules.admin.useCase.AdminUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminUseCase adminUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody AdminEntity admin){
        try {
            var result = adminUseCase.execute(admin);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<PublicAdminInfoDTO>> listAll(){
        return ResponseEntity.ok(adminUseCase.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PublicAdminInfoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(adminUseCase.findByIdUsingDTO(id));
    }

}

