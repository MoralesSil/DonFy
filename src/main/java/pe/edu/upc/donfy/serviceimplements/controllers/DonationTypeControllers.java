package pe.edu.upc.donfy.serviceimplements.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DonationTypeDTO> listar() {

        return dtS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonationTypeDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registrar(@RequestBody DonationTypeDTO dto) {
        ModelMapper m = new ModelMapper();
        DonationType nt = m.map(dto, DonationType.class);
        dtS.insert(nt);
    }
    @GetMapping("/{idTipoDonacion}")
    public DonationTypeDTO listarId(@PathVariable("idTipoDonacion") Integer idTipoDonacion  ) {
        ModelMapper m=new ModelMapper();
        DonationTypeDTO dto=m.map(dtS.listId(idTipoDonacion), DonationTypeDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody DonationTypeDTO dto) {
        ModelMapper m=new ModelMapper();
        DonationType nt=m.map(dto, DonationType.class);
        dtS.update(nt);
    }
    @DeleteMapping("/{idTipoDonacion}")
    public void eliminar(@PathVariable("idTipoDonacion") Integer idTipoDonacion) {
        dtS.delete(idTipoDonacion);
    }
}
