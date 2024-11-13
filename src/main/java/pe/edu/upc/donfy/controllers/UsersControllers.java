package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.DonanteXFechaDTO;
import pe.edu.upc.donfy.dtos.SaldoXusuarioDTO;
import pe.edu.upc.donfy.dtos.UsersDTO;
import pe.edu.upc.donfy.entities.Users;
import pe.edu.upc.donfy.serviceinterfaces.IUsersService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Users")
public class UsersControllers {
    @Autowired
    private IUsersService uS;


    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR') or hasAuthority('ONG')")
    public void modificar(@RequestBody UsersDTO dto) {
        ModelMapper m=new ModelMapper();
        Users urs=m.map(dto, Users.class);
        uS.update(urs);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Long id){
        uS.delete(id);
    }

    //Query Roles ONG por usuario

    @GetMapping("/busquedas")
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR')")
    public List<UsersDTO> buscar() {
        return uS.rolesONG().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/donantePorFecha")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
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

    @GetMapping("/saldo")
    public List<SaldoXusuarioDTO> saldoXusuario(@RequestParam("username") String username) {
        List<Float[]> lista = uS.saldoXusuario(username);
        List<SaldoXusuarioDTO>listadto=new ArrayList<>();
        for(Float[] data:lista){
            SaldoXusuarioDTO dto =  new SaldoXusuarioDTO();
            dto.setSaldo(data[0]);
            listadto.add(dto);
        }
        return listadto;
    }
}
