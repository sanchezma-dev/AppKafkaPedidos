package micro.app.usuario.repository;

import micro.app.usuario.entity.UsuarioEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioEntity, String> {

}
