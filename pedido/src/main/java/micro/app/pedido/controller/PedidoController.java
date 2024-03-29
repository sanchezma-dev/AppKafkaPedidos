package micro.app.pedido.controller;

import lombok.extern.slf4j.Slf4j;
import micro.app.pedido.dto.Solicitud;
import micro.app.pedido.exceptions.ApiResponseException;
import micro.app.pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    /**
     * Servicio pedido
     */
    @Autowired
    private IPedidoService service;

    @PostMapping(value = "/alta")
    @ResponseBody // Indica que la salida sera en JSON, como si fuera produces = "application/json"
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> alta(@RequestBody final Solicitud solicitud) { //ResquestBody = consumes = "application/json"
        log.info("Entrando en alta del pedido. PedidoController.alta");
        try {
            service.altaPedido(solicitud);
            return new ResponseEntity<>("El pedido se ha guardado con éxito", HttpStatus.OK);
        } catch (ApiResponseException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/baja/{idPedido}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> baja(@PathVariable final Long idPedido) {
        log.info("Entrando en baja del pedido. PedidoController.baja");
        try {
            service.bajaPedido(idPedido);
            return new ResponseEntity<>("El pedido se ha eliminado con éxito", HttpStatus.OK);
        } catch (ApiResponseException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }

    @PutMapping(value = "/modifica/{idPedido}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> modifica(@PathVariable("idPedido") Long id, @RequestBody Solicitud solicitud) {
        log.info("Entrando en modifica el pedido. PedidoController.modifica");
        try {
            service.modificaPedido(id, solicitud);
            return new ResponseEntity<>("El pedido se ha modificado con éxito", HttpStatus.OK);
        } catch (ApiResponseException e) {
            return ResponseEntity.status(e.getHttpStatus()).body(e.getMessage());
        }
    }
}
