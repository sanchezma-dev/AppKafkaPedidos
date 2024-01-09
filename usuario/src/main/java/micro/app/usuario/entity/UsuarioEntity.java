package micro.app.usuario.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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

    /** Apellido primero usuario*/
    @NotBlank(message = "El apellido primero es obligatorio")
    private String apellido1;

    /** Apellido segundo usuario */
    private String apellido2;

    /** Email único del usuario */
     //@NotBlank(message = "El email es obligatorio")
    //@Email(message = "El formato del correo electrónico no es válido")
    // @Indexed(unique = true)
    private String email;

    /** Telefono del usuario */
    private String telefono;

}
