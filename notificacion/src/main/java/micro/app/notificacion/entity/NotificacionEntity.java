package micro.app.notificacion.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificaciones")
public class NotificacionEntity {

    @Id
    private String id;

    /** id usuario */
    private String idUsuario;

    /** Email unico del usuario */
    @Indexed(unique = true)
    private String email;

    /** Estado el cual se encuentra la notificacion */
    private String estado;

    /** fecha de creacion */
    private Date fechaCreacion;


}
