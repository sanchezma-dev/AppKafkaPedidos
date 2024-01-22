package micro.app.pedido.service.impl;

import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.ProductoDto;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import micro.app.pedido.repository.IPedidoRepository;
import micro.app.pedido.service.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private IPedidoRepository repo;

    @Autowired
    private IPedidoConvert convertPedido;

    @Override
    public Optional<PedidoDto> altaPedido(PedidoDto pedido) {
        //FIXME Hacer en método privado
        PedidoEntity pedidoEntity= new PedidoEntity();
        pedidoEntity.setIdUsuario(pedido.getIdUsuario());
        pedidoEntity.setFecha(new Date());
        //FIXME Pasar a constante o propiedad
        pedidoEntity.setEstado("PENDIENTE");

        for (ProductoDto p: pedido.getProductos()) {
            ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
            productoPedidoEntity.setIdProducto(p.getIdProducto());
            productoPedidoEntity.setCantidad(p.getCantidad());
            productoPedidoEntity.setPedido(pedidoEntity);
            pedidoEntity.getProductosPedido().add(productoPedidoEntity);
        }
        final PedidoEntity pedidoSave = repo.save(pedidoEntity);
        // FIXME hacer excepcion propia por si llegara null
        return Optional.of(convertPedido.convertToDto(pedidoSave));
    }

}
