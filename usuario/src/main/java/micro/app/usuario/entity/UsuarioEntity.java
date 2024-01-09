package micro.app.usuario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "usuarios")
public class UsuarioEntity {

    @Id
    private String id;

    /** Nombre usuario */
    private String nombre;

    /** Apellido primero usuario */
    private String apellido1;

    /** Apellido segundo usuario */
    private String apellido2;

    /** Email unico del usuario */
    @Indexed(unique = true)
    private String email;

    /** Telefono del usuario */
    private String telefono;

}
