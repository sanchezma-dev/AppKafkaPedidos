package micro.app.usuario.repository;

import micro.app.usuario.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

    /**
     * Devuelve true si existe un usuario con ese email registrado, false en caso contrario
     * @param email
     * @return true o false
     */
    boolean existsByEmail(final String email);

    /**
     * Busca al usuario con el email dado
     * @param email
     * @return usuario o vacio en caso de no encontrarlo
     */
    Optional<UsuarioEntity> findByEmail(final String email);

}
