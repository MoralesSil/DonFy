package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.UsersDTO;
import pe.edu.upc.donfy.entities.Users;
import pe.edu.upc.donfy.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
public class UsersControllers {
    @Autowired
    private IUsersService uS;

    @GetMapping
    public List<UsersDTO> listar() {

        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registar(@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users urs = m.map(dto, Users.class);
        uS.insert(urs);
    }
    @GetMapping("/{idUsuario}")
    public UsersDTO listarId(@PathVariable("idUsuario") Integer idUsuario  ) {
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listId(idUsuario), UsersDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UsersDTO dto) {
        ModelMapper m=new ModelMapper();
        Users urs=m.map(dto, Users.class);
        uS.insert(urs);
    }
    @DeleteMapping("/{idUsuario}")
    public void eliminar(@PathVariable("idUsuario") Integer idUsuario){
        uS.delete(idUsuario);
    }
}
