package micro.app.notificacion.repository;

import micro.app.notificacion.entity.NotificacionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface INotificacionRepository extends MongoRepository<NotificacionEntity, String> {


}
