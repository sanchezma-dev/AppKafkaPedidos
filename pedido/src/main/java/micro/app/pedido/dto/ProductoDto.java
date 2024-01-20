package micro.app.pedido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProductoDto {

    /* Id producto */
    private Long idProducto;

    /* Unidades del producto */
    private int cantidad;
}
