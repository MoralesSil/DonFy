package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.DonationTypeDTO;
import pe.edu.upc.donfy.entities.DonationType;
import pe.edu.upc.donfy.serviceinterfaces.IDonationTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/DonationType")
public class DonationTypeControllers {
    @Autowired
    private IDonationTypeService dtS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR')") //Modificado para añadir acciones al donador
    public List<DonationTypeDTO> listar() {

        return dtS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonationTypeDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR')") //Modificado para añadir acciones al donador
    public void registrar(@RequestBody DonationTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        DonationType nt = m.map(dto, DonationType.class);
        dtS.insert(nt);
    }
    @GetMapping("/{idTipoDonacion}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR')") //Modificado para añadir acciones al donador
    public DonationTypeDTO listarId(@PathVariable("idTipoDonacion") Integer idTipoDonacion  ) {
        ModelMapper m=new ModelMapper();
        DonationTypeDTO dto=m.map(dtS.listId(idTipoDonacion), DonationTypeDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR') or hasAuthority('DONADOR')") //Modificado para añadir acciones al donador
    public void modificar(@RequestBody DonationTypeDTO dto) {
        ModelMapper m=new ModelMapper();
        DonationType nt=m.map(dto, DonationType.class);
        dtS.update(nt);
    }
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    @DeleteMapping("/{idTipoDonacion}")
    public void eliminar(@PathVariable("idTipoDonacion") Integer idTipoDonacion) {
        dtS.delete(idTipoDonacion);
    }
}
