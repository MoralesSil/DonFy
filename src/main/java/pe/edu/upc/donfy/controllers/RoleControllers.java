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
    public void registrar(@RequestBody RoleDTO dto) {
        ModelMapper m = new ModelMapper();
        Role nt = m.map(dto, Role.class);
        rS.insert(nt);
    }
    @GetMapping("/{id}")
    public RoleDTO listarId(@PathVariable("id") Long id  ) {
        ModelMapper m=new ModelMapper();
        RoleDTO dto=m.map(rS.listId(id), RoleDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody RoleDTO dto) {
        ModelMapper m=new ModelMapper();
        Role nt=m.map(dto, Role.class);
        rS.update(nt);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        rS.delete(id);
    }
}
