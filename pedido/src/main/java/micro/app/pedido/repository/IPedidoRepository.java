package micro.app.pedido.repository;

import micro.app.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
