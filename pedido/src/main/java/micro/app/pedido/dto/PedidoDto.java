package micro.app.pedido.dto;

import jakarta.persistence.*;
import lombok.Data;
import micro.app.pedido.entity.ProductoPedidoEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {

    private Long id;

    private String idUsuario;

    private Date fecha;

    private String estado;

    private List<ProductoPedidoEntity> productosPedido;

    /**
     * Atributo que no está en el PedidoEntity, que guarda el idProducto
     * y la cantidad del mismo
     */
    private List<ProductoDto> productos;
}
