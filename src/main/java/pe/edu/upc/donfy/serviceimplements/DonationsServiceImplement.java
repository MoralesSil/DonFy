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
    public List<String[]> listOfMonetaryDonationsByONG(int year) {
        return dR.resumenDonacionesMonetarias(year);
    }

    @Override
    public List<Donations> listDonationsByONG(String ONG) {
        return dR.findDonationsByONG(ONG);
    }

    @Override
    public List<String[]> listDonationAndONGByIds(int idDonation, int idONG) {
        return dR.findDonationAndONGByIds(idDonation, idONG);
    }


}
