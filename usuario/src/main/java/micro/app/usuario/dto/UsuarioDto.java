package micro.app.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@Data
public class UsuarioDto {

    /** Nombre usuario */
    @NotNull(message = "El nombre debe ser nulo")
    @NotEmpty(message = "El nombre debe estar informado")
    private String nombre;

    /** Apellido primero usuario*/
    @NotBlank(message = "El apellido primero es obligatorio")
    private String apellido1;

    /** Apellido segundo usuario */
    private String apellido2;

    /** Email único del usuario */
    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El formato del correo electrónico no es válido")
    @Indexed(unique = true)
    private String email;

    /** Telefono del usuario */
    private String telefono;
}
