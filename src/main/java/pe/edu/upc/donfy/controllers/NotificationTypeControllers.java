package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.NotificationTypeDTO;
import pe.edu.upc.donfy.entities.NotificationType;
import pe.edu.upc.donfy.serviceinterfaces.INotificationTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/NotificationType")
public class NotificationTypeControllers {
    @Autowired
    private INotificationTypeService ntS;

    @GetMapping
    public List<NotificationTypeDTO> listar() {

        return ntS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificationTypeDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registar(@RequestBody NotificationTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        NotificationType nt = m.map(dto, NotificationType.class);
        ntS.insert(nt);
    }
    @GetMapping("/{idTipoNotificacion}")
    public NotificationTypeDTO listarId(@PathVariable("idTipoNotificacion") Integer idTipoNotificacion  ) {
        ModelMapper m=new ModelMapper();
        NotificationTypeDTO dto=m.map(ntS.listId(idTipoNotificacion), NotificationTypeDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody NotificationTypeDTO dto) {
        ModelMapper m=new ModelMapper();
        NotificationType nt=m.map(dto, NotificationType.class);
        ntS.update(nt);
    }
    @DeleteMapping("/{idTipoNotificacion}")
    public void eliminar(@PathVariable("idTipoNotificacion") Integer idTipoNotificacion) {
        ntS.delete(idTipoNotificacion);
    }
}
