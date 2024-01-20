package micro.app.pedido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import micro.app.pedido.dto.ProductoDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos_productos")
public class ProductoPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_PRODUCTO", nullable = false)
    private Long producto;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", nullable = false)
    private PedidoEntity pedido;

    @Column(name ="cantidad")
    private int cantidad;

}
