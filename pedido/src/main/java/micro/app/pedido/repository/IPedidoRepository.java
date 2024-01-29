package micro.app.pedido.repository;

import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

    List<ProductoPedidoEntity> findProductosPedidoById(Long pedidoId);

}
