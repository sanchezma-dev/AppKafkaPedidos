package micro.app.pedido.controller;

import lombok.extern.slf4j.Slf4j;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.Solicitud;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    /** Servicio usuario */
    @Autowired
    private IPedidoService service;

    @PostMapping(value = "/alta")
    public ResponseEntity<?> alta (@RequestBody final Solicitud solicitud) {
        log.info("Entrando en alta PedidoController.alta");
        service.altaPedido(solicitud);
        return new ResponseEntity<>("Usuario guardado con éxito", HttpStatus.OK);
    }
}
