package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.DonationType;

import java.util.List;

public interface IDonationTypeService {
    public List<DonationType> list();

    public void insert(DonationType donationType);
    public DonationType listId(int idTipoDonacion);
    public void update(DonationType donationType);
    public void delete(int idTipoDonacion);
}
