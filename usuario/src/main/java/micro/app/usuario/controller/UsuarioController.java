package micro.app.usuario.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import micro.app.usuario.dto.UsuarioDto;
import micro.app.usuario.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    /** Servicio usuario */
    @Autowired
    private IUsuarioService service;

    //FIXME A la dar de alta se enviará evento kafka a notificacion para que esta mande el email de bienvenida
    @PostMapping(value = "/alta")
    public ResponseEntity<?> alta (@Valid @RequestBody final UsuarioDto usuarioDto) {
        log.info("Entrando en alta usuarioController");
            service.saveUsuario(usuarioDto);
            return new ResponseEntity<>("Usuario guardado con éxito", HttpStatus.OK);
    }

    //FIXME A la dar de baja se enviará evento kafka a notificacion para que esta mande el email de la baja
    @DeleteMapping(value = "/baja/{email}")
    public ResponseEntity<?> baja (@PathVariable final String email) {
        //FIXME Controlar si el usuario a eliminar no existe
        return null;
    }

}
