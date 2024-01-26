package micro.app.pedido.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {

    private Long id;

    private String idUsuario;

    private Date fecha;

    private String estado;

    private List<ProductoPedidoDto> productosPedido;
}
