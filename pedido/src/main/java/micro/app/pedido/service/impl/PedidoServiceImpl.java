package micro.app.pedido.service.impl;

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

    @Override
    public void altaPedido(PedidoDto pedido) {
        PedidoEntity pedidoEntity= new PedidoEntity();
        pedidoEntity.setIdUsuario(pedido.getIdUsuario());
        pedidoEntity.setFecha(new Date());
        pedidoEntity.setEstado("PENDIENTE");

        for (ProductoDto p: pedido.getProductos()) {
            ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
            productoPedidoEntity.setProducto(p.getIdProducto());
            productoPedidoEntity.setCantidad(p.getCantidad());
            productoPedidoEntity.setPedido(pedidoEntity);
            pedidoEntity.getProductos().add(productoPedidoEntity);
        }
        repo.save(pedidoEntity);
    }
}
