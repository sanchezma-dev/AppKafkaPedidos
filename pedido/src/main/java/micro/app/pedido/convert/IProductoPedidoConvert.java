package micro.app.pedido.convert;

import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.ProductoPedidoDto;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;

public interface IProductoPedidoConvert {


/**
 * Devuelve un objeto ProductoPedidoEntity a partir de un ProductoPedidoDto
 * @param source ProductoPedidoDto
 * @return ProductoPedidoEntity
 */
public ProductoPedidoEntity convertToEntity (final ProductoPedidoDto source);

/**
 * Devuelve un objeto ProductoPedidoDto a partir de un ProductoPedidoEntity
 * @param source ProductoPedidoEntity
 * @return ProductoPedidoDto
 */
public ProductoPedidoDto convertToDto (final ProductoPedidoEntity source);


}
