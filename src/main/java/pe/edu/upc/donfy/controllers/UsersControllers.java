package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.DonanteXFechaDTO;
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

    @GetMapping("/{id}")
    public UsersDTO listarId(@PathVariable("id") Long id  ) {
        ModelMapper m=new ModelMapper();
        UsersDTO dto=m.map(uS.listId(id), UsersDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody UsersDTO dto) {
        ModelMapper m=new ModelMapper();
        Users urs=m.map(dto, Users.class);
        uS.update(urs);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }

    //Query Roles ONG por usuario
    @GetMapping("/busquedas")
    public List<UsersDTO> buscar() {
        return uS.rolesONG().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/donantePorFecha")
    public List<DonanteXFechaDTO> donantePorFecha(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        List<String[]> lista = uS.donantesXfecha(startDate, endDate);
        List<DonanteXFechaDTO>listadto=new ArrayList<>();
        for(String[] data:lista){
            DonanteXFechaDTO dto =  new DonanteXFechaDTO();
            dto.setNombre(data[0]);
            listadto.add(dto);
        }
        return listadto;
    }
}
