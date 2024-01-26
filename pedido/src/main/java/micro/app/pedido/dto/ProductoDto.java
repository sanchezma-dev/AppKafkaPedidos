package micro.app.pedido.dto;

import lombok.Data;

@Data
public class ProductoDto {

    /* Id producto */
    private Long idProducto;

    /* Unidades del producto */
    private int cantidad;
}
