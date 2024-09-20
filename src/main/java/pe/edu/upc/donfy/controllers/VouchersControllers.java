package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.DonationONGDTO;
import pe.edu.upc.donfy.dtos.VouchersDTO;
import pe.edu.upc.donfy.entities.Vouchers;
import pe.edu.upc.donfy.serviceinterfaces.IVouchersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vouchers")
public class VouchersControllers {
    @Autowired
    private IVouchersService vS;
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping
    public List<VouchersDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VouchersDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    public void registrar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.insert(vrs);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/{idComprobante}")
    public VouchersDTO listarId(@PathVariable("idComprobante") Integer idComprobante) {
        ModelMapper m = new ModelMapper();
        VouchersDTO dto = m.map(vS.listId(idComprobante), VouchersDTO.class);
        return dto;
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping
    public void modificar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.update(vrs);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/{idComprobante}")
    public void eliminar(@PathVariable("idComprobante") Integer idComprobante) {
        vS.delete(idComprobante);
    }


    @GetMapping("/ListarComprobantesPorUsuario")
    public List<VouchersDTO> ComprobantesPorUsuario(@RequestParam Long iduser)
    {
        return vS.listAllVoucherForUser(iduser).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x,VouchersDTO.class);
        }).collect(Collectors.toList());
    }
}