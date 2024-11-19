package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.VouchersDTO;
import pe.edu.upc.donfy.entities.Vouchers;
import pe.edu.upc.donfy.serviceinterfaces.IVouchersService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vouchers")
public class VouchersControllers {
    @Autowired
    private IVouchersService vS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<VouchersDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VouchersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.insert(vrs);
    }

    @GetMapping("/{idComprobante}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public VouchersDTO listarId(@PathVariable("idComprobante") Integer idComprobante) {
        ModelMapper m = new ModelMapper();
        VouchersDTO dto = m.map(vS.listId(idComprobante), VouchersDTO.class);
        return dto;
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.update(vrs);
    }

    @DeleteMapping("/{idComprobante}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("idComprobante") Integer idComprobante) {
        vS.delete(idComprobante);
    }


    @GetMapping("/ComprobanteFecha")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<VouchersDTO> ObtenerComprobanteFecha(){
        List<String[]> lista=vS.GenerarComprobanteFecha();
        List<VouchersDTO>listaDTO=new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        for(String[]columna:lista){
            VouchersDTO dto=new VouchersDTO();
            dto.setIdComprobante(Integer.parseInt(columna[0]));
            dto.setFechaEmision(LocalDateTime.parse(columna[1],formatter));
            dto.setTotal(Double.parseDouble(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }


    @GetMapping("/ListarComprobantesPorUsuario/{iduser}")
    public List<VouchersDTO> ComprobantesPorUsuario(@PathVariable Long iduser) {
        return vS.listAllVoucherForUser(iduser).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VouchersDTO.class);
        }).collect(Collectors.toList());
    }


}


//