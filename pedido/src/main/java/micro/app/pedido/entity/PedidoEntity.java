package micro.app.pedido.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_USUARIO", nullable = false)
    private String idUsuario;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    // Relacion unidireccional. Un pedido puede tener varios productos
    // No se pone el campo ID_PEDIDO en el entity ProductoPedidoEntity
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ID_PEDIDO")
    private List<ProductoPedidoEntity> productos = new ArrayList<>();

}
