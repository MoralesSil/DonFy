package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.donfy.dtos.DonationSummaryDTO;
import pe.edu.upc.donfy.dtos.DonationsDTO;
import pe.edu.upc.donfy.dtos.DonativosPhysicalDTO;
import pe.edu.upc.donfy.dtos.TrendsDonationsDTO;
import pe.edu.upc.donfy.dtos.*;
import pe.edu.upc.donfy.entities.Donations;
import pe.edu.upc.donfy.serviceinterfaces.IDonationsService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Donations")
public class DonationsControllers {
    @Autowired
    private IDonationsService dC;

    @GetMapping
    public List<DonationsDTO> listar(){
        return dC.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonationsDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public void registar(@RequestBody DonationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Donations donations = m.map(dto, Donations.class);
        dC.insert(donations);
    }
    @GetMapping("/{idDonation}")
    public DonationsDTO listarId(@PathVariable("idUsuario") Integer idDonation) {
        ModelMapper m=new ModelMapper();
        DonationsDTO dto=m.map(dC.listId(idDonation), DonationsDTO.class);
        return dto;
    }
    @PutMapping
    public void modificar(@RequestBody DonationsDTO dto) {
        ModelMapper m=new ModelMapper();
        Donations donations = m.map(dto, Donations.class);
        dC.update(donations);
    }
    @DeleteMapping("/{idDonation}")
    public void eliminar(@PathVariable("idDonation") Integer idDonation){
        dC.delete(idDonation);
    }

    @GetMapping("/FiltrarDonativosFisicos")
    public List<DonativosPhysicalDTO> FiltrarPorEstado(@RequestParam String estado)
    {
        return dC.listDonationsForYourStatus(estado).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonativosPhysicalDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/ResumenMonetarioPorONG")
    public List<DonationSummaryDTO> TotalDonadoPorONG()
    {
        return dC.listOfMonetaryDonationsByONG().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonationSummaryDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/Users/{userId}/physical-donations")
    public List<PhysicalDonationsByUserIdAndStatusDTO> DonacionesFisicaPorUsuario(@PathVariable("userId") Long User_id_receptor) {
        List<PhysicalDonationsByUserIdAndStatusDTO> listaDTO = new ArrayList<>();
        dC.listOfPhysicalDonationsByUserIdAndStatus(User_id_receptor).stream().forEach(x -> {
            ModelMapper m = new ModelMapper();
            PhysicalDonationsByUserIdAndStatusDTO dto = m.map(x, PhysicalDonationsByUserIdAndStatusDTO.class);
            listaDTO.add(dto);
        });
        return listaDTO;
    }
    @GetMapping("/donation-statistics")
    public List<DonationStatisticsDTO> obtenerEstadisticas() {
        List<String[]> lista = dC.getDonationStatistics();
        List<DonationStatisticsDTO> listaDTO = new ArrayList<>();

        for (String[] columna : lista) {
            DonationStatisticsDTO dto = new DonationStatisticsDTO();
            dto.setTotalDonativos(Long.parseLong(columna[0]));
            dto.setValorTotalEstimado(Double.parseDouble(columna[1]));
            dto.setCantidadONGBeneficiadas(Long.parseLong(columna[2]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }
    @GetMapping("/Users/{userId}/DonativosporUsuario")
    public List<DonationsDTO> getDonationsByUserId(@PathVariable Long userId) {
        List<Donations> donations = dC.findDonationsByUserId(userId);
        ModelMapper modelMapper = new ModelMapper();
        return donations.stream()
                .map(donation -> modelMapper.map(donation, DonationsDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/tendenciasDonacionesMes")
    public List<TrendsDonationsDTO> obtener() {
        List<String[]>lista=dC.tendenciasDonacionesMeses();
        List<TrendsDonationsDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista) {
            TrendsDonationsDTO dto=new TrendsDonationsDTO();
            dto.setDonationType(columna[0]);
            dto.setDate(LocalDate.parse(columna[1]));
            dto.setTotalDonations(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
