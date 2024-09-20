package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Notifications;

import java.util.List;

public interface INotificationsService {
    public List<Notifications> list();
    public void insert(Notifications notification);
    public Notifications listId(int idNotificacion);
    public void delete(int idNotificacion);
    public List<Notifications> searchNotificationsByUserId(Long userid);
}
