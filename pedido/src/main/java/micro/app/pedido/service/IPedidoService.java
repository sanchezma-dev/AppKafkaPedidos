package micro.app.pedido.service;

import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.Solicitud;

public interface IPedidoService {

    public PedidoDto altaPedido(final Solicitud solicitud);

    public void bajaPedido(final Long idPedido);
}
