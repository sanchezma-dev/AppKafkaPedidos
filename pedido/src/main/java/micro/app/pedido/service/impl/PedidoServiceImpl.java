package micro.app.pedido.service.impl;

import lombok.extern.slf4j.Slf4j;
import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.ProductoDto;
import micro.app.pedido.dto.Solicitud;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import micro.app.pedido.exceptions.ApiResponseException;
import micro.app.pedido.repository.IPedidoRepository;
import micro.app.pedido.service.IPedidoService;
import micro.app.pedido.utils.EstadoConstantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    // Metodos privados
    private PedidoEntity cargaPedido(final Solicitud solicitud) {
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdUsuario(solicitud.getIdUsuario());
        pedidoEntity.setFecha(new Date());
        pedidoEntity.setEstado(EstadoConstantes.PENDIENTE);
        return pedidoEntity;
    }

    private void cargaProdPedido(final List<ProductoDto> productos, final PedidoEntity pedido) {
        for (final ProductoDto p: productos) {
            final ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
            productoPedidoEntity.setIdProducto(p.getIdProducto());
            productoPedidoEntity.setCantidad(p.getCantidad());
            productoPedidoEntity.setPedido(pedido);
            pedido.getProductosPedido().add(productoPedidoEntity);
        }
    }

}
