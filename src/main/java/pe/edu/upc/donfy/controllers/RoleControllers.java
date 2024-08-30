package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.RoleDTO;
import pe.edu.upc.donfy.entities.Role;
import pe.edu.upc.donfy.serviceinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Role")
public class RoleControllers {
    @Autowired
    private IRoleService rS;

    @GetMapping
    public List<RoleDTO> listar() {

        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RoleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role rol = m.map(dto, Role.class);
        rS.insert(rol);
    }
    @GetMapping("/{idRolUsuario}")
    public RoleDTO listarId(@PathVariable("idRolUsuario") Integer idRolUsuario  ) {
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rS.listId(idRolUsuario), RoleDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m=new ModelMapper();
        Role rol=m.map(dto, Role.class);
        rS.insert(rol);
    }
    @DeleteMapping("/{idRolUsuario}")
    public void eliminar(@PathVariable("idRolUsuario") Integer idRolUsuario){
        rS.delete(idRolUsuario);
    }
}
