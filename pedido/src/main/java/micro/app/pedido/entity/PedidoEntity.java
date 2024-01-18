package micro.app.pedido.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "idUsuario", nullable = false)
    private String idUsuario;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "estado", nullable = false)
    private String estado;

}
