package pe.edu.upc.donfy.serviceimplements.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.DonationType;
import pe.edu.upc.donfy.repositories.IDonationTypeRepository;
import pe.edu.upc.donfy.serviceinterfaces.IDonationTypeService;

import java.util.List;

@Service
public class DonationTypeServiceImplement implements IDonationTypeService {
    @Autowired
    private IDonationTypeRepository dtR;

    @Override
    public List<DonationType> list() {
        return dtR.findAll();
    }

    @Override
    public void insert(DonationType donationType) {
        dtR.save(donationType);
    }

    @Override
    public DonationType listId(int idTipoDonacion) {
        return dtR.findById(idTipoDonacion).orElse(new DonationType());
    }

    @Override
    public void update(DonationType donationType) {
        dtR.save(donationType);
    }

    @Override
    public void delete(int idTipoDonacion) {
        dtR.deleteById(idTipoDonacion);
    }
}
