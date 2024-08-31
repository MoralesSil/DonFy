package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Notifications;

import java.util.List;

public interface INotificationsService {
    public List<Notifications> list();
    public void insert(Notifications notification);
    public Notifications listId(int idNotifications);
    public void delete(int idNotifications);
}
