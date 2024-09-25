package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.NotificationTypeDTO;
import pe.edu.upc.donfy.dtos.NotificationsDTO;
import pe.edu.upc.donfy.entities.NotificationType;
import pe.edu.upc.donfy.entities.Notifications;
import pe.edu.upc.donfy.serviceinterfaces.INotificationsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Notifications")
public class NotificationsControllers {
    @Autowired
    private INotificationsService nS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<NotificationsDTO> listar() {

        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationsDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody NotificationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Notifications n = m.map(dto, Notifications.class);
        nS.insert(n);
    }

    @GetMapping("/{idNotificacion}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public NotificationsDTO listarId(@PathVariable ("idNotificacion") Integer idNotificacion) {
        ModelMapper m = new ModelMapper();
        NotificationsDTO dto = m.map(nS.listId(idNotificacion), NotificationsDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody NotificationsDTO dto) {
        ModelMapper m=new ModelMapper();
        Notifications n=m.map(dto, Notifications.class);
        nS.update(n);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable ("idNotification") Integer idNotificacion) {
        nS.delete(idNotificacion);
    }

    @GetMapping("/Users/{userId}/NotificationsByUser")
    @PreAuthorize("hasAuthority('DONADOR') OR hasAuthority('ONG')")
    public List<NotificationsDTO> getNotificationsByUserId(@PathVariable Long userId) {
        List<Notifications> notifications = nS.NotificationsByUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        return notifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationsDTO.class))
                .collect(Collectors.toList());
    }
}
