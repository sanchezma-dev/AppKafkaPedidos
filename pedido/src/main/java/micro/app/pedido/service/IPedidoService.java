package micro.app.pedido.service;

import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.entity.PedidoEntity;

import java.util.Optional;

public interface IPedidoService {

    public Optional<PedidoDto> altaPedido(final PedidoDto pedido);
}
