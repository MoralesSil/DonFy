package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Donations;

import java.util.List;

public interface IDonationsService {

    public List<Donations> list();
    public void insert(Donations donations);
    public void update(Donations donations);
    public Donations listId(int idDonations);
    public void delete(int idDonations);
    public List<Donations> listDonationsForYourStatus(String estado);
    public List<String[]> listOfMonetaryDonationsByDonante(int year, Long iduser);
    public List<Donations> listDonationsByONG(int ONG);
    public List<String[]> listDonationAndONGByIds(int idDonation, Long idONG);
    public List<Donations> listDonationsByDonationsType(String donationsType);

    public List<String[]> tendenciasDonacionesMeses();
    public List<Donations> listOfPhysicalDonationsByUserIdAndStatus(Long Users_id_receptor);
    public List<String[]> getDonationStatistics();
    public List<Donations> findDonationsByUserId(Long Users_id_receptor);
    public List<String[]>personasConMaxDonaciones();
    public List<String[]> getDonationOngYear(int year);
}
