package micro.app.pedido.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PedidoDto {

    private Long id;

    private String idUsuario;

    private Date fecha;

    private String estado;

    private List<ProductoPedidoDto> productosPedido;

    /**
     * Atributo que no está en el PedidoEntity, que guarda el idProducto
     * y la cantidad del mismo
     */
    private List<Solicitud> listaSolicitud = new ArrayList<>();
}
