package micro.app.pedido.dto;

import lombok.Data;

import java.util.List;

@Data
public class Solicitud {

    /* Identificador del usuario que hace el Pedido */
    private String idUsuario;

    /* Lista de productoDto */
    private List<ProductoDto> productos;
}
