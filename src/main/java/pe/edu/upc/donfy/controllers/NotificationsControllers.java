package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.NotificationsDTO;
import pe.edu.upc.donfy.entities.Notifications;
import pe.edu.upc.donfy.serviceinterfaces.INotificationsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("Notifications")
public class NotificationsControllers {
    @Autowired
    private INotificationsService nS;

    @GetMapping
    public List<NotificationsDTO> listar() {

        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Notifications n = m.map(dto, Notifications.class);
        nS.insert(n);
    }

    @GetMapping("/{idNotificacion}")
    public NotificationsDTO listarId(@PathVariable ("idNotificacion") Integer idNotificacion) {
        ModelMapper m = new ModelMapper();
        NotificationsDTO dto = m.map(nS.listId(idNotificacion), NotificationsDTO.class);
        return dto;
    }

    @DeleteMapping
    public void eliminar(@PathVariable ("idNotification") Integer idNotificacion) {
        nS.delete(idNotificacion);
    }

}
