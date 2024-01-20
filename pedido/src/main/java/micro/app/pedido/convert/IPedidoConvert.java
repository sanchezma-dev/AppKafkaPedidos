package micro.app.pedido.convert;

import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.entity.PedidoEntity;

public interface IPedidoConvert {

    /**
     * Devuelve un objeto PedidoEntity a partir de un PedidoDto
     * @param source PedidoDto
     * @return PedidoEntity
     */
    public PedidoEntity convertToEntity (final PedidoDto source);

    /**
     * Devuelve un objeto PedidoDto a partir de un PedidoEntity
     * @param source PedidoEntity
     * @return PedidoDto
     */
    public PedidoDto convertToDto (final PedidoEntity source);
}
