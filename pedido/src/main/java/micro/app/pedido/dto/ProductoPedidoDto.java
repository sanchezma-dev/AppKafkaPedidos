package micro.app.pedido.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import micro.app.pedido.entity.PedidoEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoPedidoDto {

    private Long id;

    private Long producto;

    private PedidoDto pedido;

    private int cantidad;
}
