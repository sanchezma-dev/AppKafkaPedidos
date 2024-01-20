package micro.app.pedido.convert.impl;

import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.convert.IProductoPedidoConvert;
import micro.app.pedido.dto.ProductoPedidoDto;
import micro.app.pedido.entity.ProductoPedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoPedidoConvertImpl implements IProductoPedidoConvert {

    @Autowired
    private IPedidoConvert convertPedido;

    @Override
    public ProductoPedidoEntity convertToEntity(ProductoPedidoDto source) {
        final ProductoPedidoEntity target = new ProductoPedidoEntity();
        target.setId(source.getId());
        target.setProducto(source.getProducto());
        target.setPedido(convertPedido.convertToEntity(source.getPedido()));
        target.setCantidad(source.getCantidad());
        return target;
    }

    @Override
    public ProductoPedidoDto convertToDto(ProductoPedidoEntity source) {
        final ProductoPedidoDto target = new ProductoPedidoDto();
        target.setId(source.getId());
        target.setProducto(source.getProducto());
        target.setPedido(convertPedido.convertToDto(source.getPedido()));
        target.setCantidad(source.getCantidad());
        return target;
    }
}
