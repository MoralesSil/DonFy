package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.VouchersDTO;
import pe.edu.upc.donfy.entities.Vouchers;
import pe.edu.upc.donfy.serviceinterfaces.IVouchersService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vouchers")
public class VouchersControllers {
    @Autowired
    private IVouchersService vS;

    @GetMapping
    public List<VouchersDTO> listar() {
        return vS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, VouchersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.insert(vrs);
    }

    @GetMapping("/{idComprobante}")
    public VouchersDTO listarId(@PathVariable("idComprobante") Integer idComprobante) {
        ModelMapper m = new ModelMapper();
        VouchersDTO dto = m.map(vS.listId(idComprobante), VouchersDTO.class);
        return dto;
    }

    @PutMapping
    public void modificar(@RequestBody VouchersDTO dto) {
        ModelMapper m = new ModelMapper();
        Vouchers vrs = m.map(dto, Vouchers.class);
        vS.update(vrs);
    }


    @DeleteMapping("/{idComprobante}")
    public void eliminar(@PathVariable("idComprobante") Integer idComprobante) {
        vS.delete(idComprobante);
    }

    @GetMapping("/by-donador")
    public List<VouchersDTO> getComprobantesByDonador(
            @RequestParam String nombreDonador) {
        List<Object[]> comprobantes = vS.ComprobantePorDonador(nombreDonador);

        // Convertir a lista de DTOs manualmente
        List<VouchersDTO> dtoList = new ArrayList<>();
        for (Object[] obj : comprobantes) {
            VouchersDTO dto = new VouchersDTO();
            dto.setIdComprobante((Integer) obj[0]);
            dto.setDescripcion((String) obj[1]);
            dto.setFechaEmision((Date) obj[2]);
            dto.setTotal((Double) obj[3]);
            dto.setNombreDonante((String) obj[4]);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @GetMapping("/report-by-date")
    public List<VouchersDTO> gerarReporteFecha(
            @RequestParam String startDate,
            @RequestParam String endDate) {
        List<Object[]> vouchers = vS.GerarReporteFecha(startDate, endDate);

        // Convertir a lista de DTOs manualmente
        List<VouchersDTO> dtoList = new ArrayList<>();
        for (Object[] obj : vouchers) {
            VouchersDTO dto = new VouchersDTO();
            dto.setIdComprobante((Integer) obj[0]);
            dto.setFechaEmision((Date) obj[1]);
            dto.setTotal((Double) obj[2]);
            dto.setNombreDonante((String) obj[3]);
            dtoList.add(dto);
        }
        return dtoList;
    }

}


