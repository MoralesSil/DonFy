package pe.edu.upc.donfy.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.NotificationType;
import pe.edu.upc.donfy.repositories.INotificationTypeRepository;
import pe.edu.upc.donfy.serviceinterfaces.INotificationTypeService;

import java.util.List;

@Service
public class NotificationTypeServiceImplement implements INotificationTypeService {
    @Autowired
    private INotificationTypeRepository ntR;

    @Override
    public List<NotificationType> list() {
        return ntR.findAll();
    }

    @Override
    public void insert(NotificationType notificationType) {
        ntR.save(notificationType);
    }

    @Override
    public NotificationType listId(int idTipoNotificacion) {
        return ntR.findById(idTipoNotificacion).orElse(new NotificationType());
    }

    @Override
    public void update(NotificationType notificationType) {
        ntR.save(notificationType);
    }

    @Override
    public void delete(int idTipoNotificacion) {
        ntR.deleteById(idTipoNotificacion);
    }
}
