package micro.app.usuario.repository;

import micro.app.usuario.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

    /**
     * Devuelve true si existe un usuario con ese email registrado, false en caso contrario
     * @param email
     * @return true o false
     */
    boolean existsByEmail(String email);

}
