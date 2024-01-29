package micro.app.pedido.service.impl;

import lombok.extern.slf4j.Slf4j;
import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.*;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import micro.app.pedido.exceptions.ApiResponseException;
import micro.app.pedido.repository.IPedidoRepository;
import micro.app.pedido.service.IPedidoService;
import micro.app.pedido.utils.EstadoConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private IPedidoConvert convertPedido;

    @Override
    public PedidoDto altaPedido(Solicitud solicitud) {
        log.info("Entra en PedidoServiceImpl.altaPedido");
        // Informa el pedidoEntity
        final PedidoEntity pedidoEntity = cargaPedido(solicitud);
        // Carga y guarda en pedido el productoPedidoEntity
        cargaProdPedido(solicitud.getProductos(), pedidoEntity);

        final PedidoEntity pedidoSave = repo.save(pedidoEntity);
        // Verifca si el pedido se ha guardado correctamente
        if (pedidoSave == null) {
            throw ApiResponseException.of("Error al crear el pedido", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return convertPedido.convertToDto(pedidoSave);
    }

    @Override
    public void bajaPedido(Long idPedido) {
        log.info("Entra en PedidoServiceImpl.bajaPedido");
        final PedidoEntity pedido = repo.findById(idPedido)
                .orElseThrow(() -> {
                    log.error("Error en PedidoServiceImpl.bajaPedido. No existe ningún Pedido asociado al identificador proporcionado: {}", idPedido);
                    return ApiResponseException.of("El pedido a eliminar no existe", HttpStatus.NOT_FOUND);
                });
        // Si existe el pedido, se elimina
        repo.delete(pedido);
    }

    @Override
    public PedidoDto modificaPedido(Long idPedido, Solicitud solicitud) {
        // Si no existe el pedido a modificar, lanzo la excepcion
        final PedidoEntity pedidoEntity = repo.findById(idPedido)
                .orElseThrow(() -> {
                    log.error("Error en PedidoServiceImpl.modificaPedido. No existe ningún Pedido asociado al identificador proporcionado: {}", idPedido);
                    return ApiResponseException.of("El pedido a modificar no existe", HttpStatus.NOT_FOUND);
                });
        // Validacion del estado del pedido
        if (EstadoConstantes.FINALIZADO.equals(pedidoEntity.getEstado())) {
            log.error("Error en PedidoServiceImpl.modificaPedido. El pedido a modificar ya se encuentra FINALIZADO");
            throw  ApiResponseException.of("El pedido a modificar ya se encuentra FINALIZADO", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        // Actualiza pedido
        pedidoEntity.setFecha(new Date());
        pedidoEntity.setEstado(EstadoConstantes.PENDIENTE);
        // Actualizar los productos del pedido
        pedidoEntity.getProductosPedido().clear();
        cargaProdPedido(solicitud.getProductos(), pedidoEntity);

        return convertPedido.convertToDto(repo.save(pedidoEntity));
    }


    // Metodos privados
    private PedidoEntity cargaPedido(final Solicitud solicitud) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdUsuario(solicitud.getIdUsuario());
        pedidoEntity.setFecha(new Date());
        pedidoEntity.setEstado(EstadoConstantes.PENDIENTE);
        return pedidoEntity;
    }

    private void cargaProdPedido(final List<ProductoDto> productos, final PedidoEntity pedido) {
        for (final ProductoDto p : productos) {
            final ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
            productoPedidoEntity.setIdProducto(p.getIdProducto());
            productoPedidoEntity.setCantidad(p.getCantidad());
            productoPedidoEntity.setPedido(pedido);
            pedido.getProductosPedido().add(productoPedidoEntity);
        }
    }

}
