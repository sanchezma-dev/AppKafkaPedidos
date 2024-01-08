package micro.app.usuario.controller;

import jakarta.validation.Valid;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.service.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {


    /** Servicio usuario */
    @Autowired
    private IUsuarioService service;

    @PostMapping(value = "/alta")
    public ResponseEntity<?> alta (@Valid @RequestBody final UsuarioDto usuarioDto) {
        return ResponseEntity.status(HttpStatus.OK).body(service.saveUsuario(usuarioDto));
    }

}
