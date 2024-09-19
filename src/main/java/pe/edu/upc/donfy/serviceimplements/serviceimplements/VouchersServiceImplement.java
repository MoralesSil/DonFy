package pe.edu.upc.donfy.serviceimplements.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.donfy.entities.Vouchers;
import pe.edu.upc.donfy.repositories.IVouchersRepository;
import pe.edu.upc.donfy.serviceinterfaces.IVouchersService;

import java.util.List;

@Service
public class VouchersServiceImplement implements IVouchersService {
    @Autowired
    private IVouchersRepository vR;

    @Override
    public List<Vouchers> list() {
        return vR.findAll();
    }

    @Override
    public void insert(Vouchers vouchers) {
        vR.save(vouchers);
    }

    @Override
    public void update(Vouchers vouchers) {
        vR.save(vouchers);
    }

    @Override
    public Vouchers listId(int idVouchers) {
        return vR.findById(idVouchers).orElse(new Vouchers());
    }

    @Override
    public void delete(int idVoucher) {
        vR.deleteById(idVoucher);
    }

    @Override
    public List<Vouchers> getAllComprobantes() {
        return vR.findAll();
    }
}
