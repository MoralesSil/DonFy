package pe.edu.upc.donfy.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.Notifications;
import pe.edu.upc.donfy.repositories.INotificationsRepository;
import pe.edu.upc.donfy.serviceinterfaces.INotificationsService;

import java.util.List;

@Service
public class NotificationsServiceImplement implements INotificationsService {
    @Autowired
    private INotificationsRepository nR;

    @Override
    public List<Notifications> list(){
        return nR.findAll();
    }

    @Override
    public void insert(Notifications notifications){
        nR.save(notifications);
    }

    @Override
    public Notifications listId(int idNotificacion){
        return nR.findById(idNotificacion).orElse(new Notifications());
    }

    @Override
    public void delete(int idNotificacion){
        nR.deleteById(idNotificacion);
    }

}
