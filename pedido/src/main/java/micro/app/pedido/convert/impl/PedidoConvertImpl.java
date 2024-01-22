package micro.app.pedido.convert.impl;

import micro.app.pedido.convert.IPedidoConvert;
import micro.app.pedido.dto.PedidoDto;
import micro.app.pedido.dto.ProductoPedidoDto;
import micro.app.pedido.entity.PedidoEntity;
import micro.app.pedido.entity.ProductoPedidoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoConvertImpl implements IPedidoConvert {


    @Override
    public PedidoEntity convertToEntity(PedidoDto pedidoDto) {
        if (pedidoDto == null) {
            return null;
        }

        PedidoEntity pedidoEntity = new PedidoEntity();
        pedidoEntity.setIdUsuario(pedidoDto.getIdUsuario());
        pedidoEntity.setFecha(pedidoDto.getFecha());
        pedidoEntity.setEstado(pedidoDto.getEstado());
        // Lista de ProductoPedidoDto
        if (pedidoDto.getProductosPedido() != null) {
            List<ProductoPedidoEntity> productosPedidoEntities = pedidoDto.getProductosPedido().stream()
                    .map(this::convertToProductoPedidoEntity)
                    .collect(Collectors.toList());
            pedidoEntity.setProductosPedido(productosPedidoEntities);
        }

        return pedidoEntity;
    }

    @Override
    public PedidoDto convertToDto(PedidoEntity pedidoEntity) {
        if (pedidoEntity == null) {
            return null;
        }

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setIdUsuario(pedidoEntity.getIdUsuario());
        pedidoDto.setFecha(pedidoEntity.getFecha());
        pedidoDto.setEstado(pedidoEntity.getEstado());

        if (pedidoEntity.getProductosPedido() != null) {
            List<ProductoPedidoDto> productosPedidoDtos = pedidoEntity.getProductosPedido().stream()
                    .map(this::convertToProductoPedidoDto)
                    .collect(Collectors.toList());
            pedidoDto.setProductosPedido(productosPedidoDtos);
        }

        return pedidoDto;
    }

    private ProductoPedidoEntity convertToProductoPedidoEntity(ProductoPedidoDto productoPedidoDto) {
        if (productoPedidoDto == null) {
            return null;
        }
        ProductoPedidoEntity productoPedidoEntity = new ProductoPedidoEntity();
        productoPedidoEntity.setIdProducto(productoPedidoDto.getIdProducto());
        productoPedidoEntity.setCantidad(productoPedidoDto.getCantidad());

        return productoPedidoEntity;
    }

    private ProductoPedidoDto convertToProductoPedidoDto(ProductoPedidoEntity productoPedidoEntity) {
        if (productoPedidoEntity == null) {
            return null;
        }

        ProductoPedidoDto productoPedidoDto = new ProductoPedidoDto();
        productoPedidoDto.setIdProducto(productoPedidoEntity.getIdProducto());
        productoPedidoDto.setCantidad(productoPedidoEntity.getCantidad());

        return productoPedidoDto;
    }
}
