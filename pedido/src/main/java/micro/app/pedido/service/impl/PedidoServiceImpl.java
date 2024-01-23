package micro.app.pedido.service.impl;

import lombok.extern.slf4j.Slf4j;
import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.ProductoDto;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import micro.app.pedido.exceptions.ApiResponseException;
import micro.app.pedido.repository.IPedidoRepository;
import micro.app.pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Slf4j
@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private IPedidoConvert convertPedido;

    @Override
    public Optional<PedidoDto> altaPedido(PedidoDto pedido) {
        log.info("Entra en PedidoServiceImpl.altaPedido");
        //FIXME Hacer en método privado
        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdUsuario(pedido.getIdUsuario());
        pedidoEntity.setFecha(new Date());
        //FIXME Pasar a constante o propiedad
        pedidoEntity.setEstado("PENDIENTE");

        for (ProductoDto p : pedido.getProductos()) {
            ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
            productoPedidoEntity.setIdProducto(p.getIdProducto());
            productoPedidoEntity.setCantidad(p.getCantidad());
            productoPedidoEntity.setPedido(pedidoEntity);
            pedidoEntity.getProductosPedido().add(productoPedidoEntity);
        }
        final PedidoEntity pedidoSave = repo.save(pedidoEntity);
        if (pedidoSave == null) {
            throw ApiResponseException.of("Error al crear el pedido", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return Optional.of(pedidoSave)
                .map(convertPedido::convertToDto);
    }

}
