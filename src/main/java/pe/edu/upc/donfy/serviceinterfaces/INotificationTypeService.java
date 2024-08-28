package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.NotificationType;

import java.util.List;

public interface INotificationTypeService {
    public List<NotificationType> list();

    public void insert(NotificationType notificationType);
    public NotificationType listId(int idTipoNotificacion);
    public void update(NotificationType notificationType);
    public void delete(int idTipoNotificacion);
}
