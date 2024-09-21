package pe.edu.upc.donfy.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<DonationsDTO> listar(){
        return dC.list().stream().map(x-> {
            ModelMapper m = new ModelMapper();
            return m.map(x, DonationsDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    @PreAuthorize("hasAuthority('DONADOR')")
    public void registar(@RequestBody DonationsDTO dto) {
        ModelMapper m = new ModelMapper();
        Donations donations = m.map(dto, Donations.class);
        dC.insert(donations);
    }
    @GetMapping("/{idDonation}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public DonationsDTO listarId(@PathVariable("idUsuario") Integer idDonation) {
        ModelMapper m=new ModelMapper();
        DonationsDTO dto=m.map(dC.listId(idDonation), DonationsDTO.class);
        return dto;
    }
    @PutMapping
    @PreAuthorize("hasAuthority('DONADOR')")
    public void modificar(@RequestBody DonationsDTO dto) {
        ModelMapper m=new ModelMapper();
        Donations donations = m.map(dto, Donations.class);
        dC.update(donations);
    }
    @DeleteMapping("/{idDonation}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
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
    @PreAuthorize("hasAuthority('DONADOR')")
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
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<DonationStatisticsDTO> obtenerEstadisticas() {
        List<String[]> resultados = dC.getDonationStatistics();
        List<DonationStatisticsDTO> listaDTO = new ArrayList<>();

        for (String[] resultado : resultados) {
            DonationStatisticsDTO dto = new DonationStatisticsDTO();
            dto.setNombreONG(resultado[0]);
            dto.setTotalDonativos(Long.parseLong(resultado[1]));
            dto.setValorTotalEstimado(Double.parseDouble(resultado[2]));
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
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<TrendsDonationsDTO> obtenerTendencias() {
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
    @GetMapping("/MontoAnualporONG")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<DonationsSummaryYearONGDTO> MontoAnualporONG(@RequestParam int year) {
        List<String[]> results = dC.getDonationOngYear(year);
        List<DonationsSummaryYearONGDTO> listaDTO = new ArrayList<>();

        for (String[] columna : results) {
            DonationsSummaryYearONGDTO dto = new DonationsSummaryYearONGDTO();
            dto.setNombreONG(columna[0]);
            dto.setMontoDonado(Float.parseFloat(columna[1]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }

    @GetMapping("/personasConMasDonaciones")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public List<PersonasconMasDonacionesDTO> obtenerPersonas() {
        List<String[]>lista=dC.personasConMaxDonaciones();
        List<PersonasconMasDonacionesDTO>listaDTO=new ArrayList<>();
        for(String[]columna:lista) {
            PersonasconMasDonacionesDTO dto=new PersonasconMasDonacionesDTO();
            dto.setNombre(columna[0]);
            dto.setNombreTipoDonation(columna[1]);
            dto.setTotalDonaciones(Integer.parseInt(columna[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
