package pe.edu.upc.donfy.serviceinterfaces;

import pe.edu.upc.donfy.entities.Vouchers;

import java.util.List;

public interface IVouchersService {
    List<Vouchers> list();
    void insert(Vouchers vouchers);
    void update(Vouchers vouchers);
    Vouchers listId(int idVouchers);
    void delete(int idVoucher);

    List<String[]> GenerarComprobanteFecha();

    List<Vouchers> listAllVoucherForUser(Long idUser);

}
