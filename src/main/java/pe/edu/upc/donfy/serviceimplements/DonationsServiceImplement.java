package pe.edu.upc.donfy.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.Donations;
import pe.edu.upc.donfy.repositories.IDonationsRepository;
import pe.edu.upc.donfy.serviceinterfaces.IDonationsService;

import java.util.List;

@Service
public class DonationsServiceImplement implements IDonationsService {

    @Autowired
    private IDonationsRepository dR;

    @Override
    public List<Donations> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Donations donations) {
        dR.save(donations);
    }

    @Override
    public void update(Donations donations) {
        dR.save(donations);
    }

    @Override
    public Donations listId(int idDonations) {
        return dR.findById(idDonations).orElse(new Donations());
    }

    @Override
    public void delete(int idDonations) {
        dR.deleteById(idDonations);
    }

    @Override
    public List<Donations> listDonationsForYourStatus(String estado) {
        return dR.findDonationsForYourStatus(estado);
    }

    @Override
    public List<String[]> listOfMonetaryDonationsByDonante(int year, String username) {
        return dR.resumenDonacionesMonetariasPorDonador(year, username);
    }

    @Override
    public List<Donations> listDonationsByONG(String ongUsername) {

        return dR.findDonationsByONG(ongUsername);
    }

    @Override
    public List<String[]> listDonationAndONGByIds(int idDonation, Long idONG) {
        return dR.findDonationAndONGByIds(idDonation, idONG);
    }

    @Override
    public List<Donations> listDonationsByDonationsType(String donationsType) {
        return dR.findDonationsByDonationsType(donationsType);
    }

    @Override
    public List<String[]> tendenciasDonacionesMeses() {
        return dR.tendenciasDonacionesMeses();
    }

    @Override
    public List<Donations> listOfPhysicalDonationsByUserIdAndStatus(Long Users_id_receptor) {
        return dR.findPhysicalDonationsByUserIdAndStatus(Users_id_receptor);
    }

    @Override
    public List<String[]> getDonationStatistics() {
        return dR.getDonationStatistics();
    }

    @Override
    public List<Donations> findDonationsByUserId(Long Users_id_receptor) {
        return dR.findByUserId(Users_id_receptor);
    }

    @Override
    public List<String[]> personasConMaxDonaciones() {
        return dR.personasConMaxDonaciones();
    }

    @Override
    public List<String[]> getDonationOngYear(int year) {
        return dR.obtenerTotalDonadoPorONG(year);
    }

    @Override
    public List<Donations> listDonationForUser(String username) {
        return dR.findDonationsByUserIdAndRole(username);
    }

    @Override
    public List<Donations> listDonationActivate() {
        return dR.findAllActiveDonations();
    }

    @Override
    public List<String[]> obtenerCantidadDonativosPorTipoYM(int mes) {
        return dR.obtenerCantidadDonativosFisicosPorMes(mes);
    }

}
