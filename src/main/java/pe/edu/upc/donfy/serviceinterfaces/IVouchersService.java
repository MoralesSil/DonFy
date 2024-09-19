package pe.edu.upc.donfy.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.donfy.entities.Vouchers;

import java.util.List;

public interface IVouchersService {
    List<Vouchers> list();
    void insert(Vouchers vouchers);
    void update(Vouchers vouchers);
    Vouchers listId(int idVouchers);
    void delete(int idVoucher);
    List<Vouchers> getAllComprobantes();
    public List<Object[]> GerarReporteFecha(@Param("startDate") String startDate, @Param("endDate") String endDate);
    List<Object[]> ComprobantePorDonador(@Param("nombreDonador") String nombreDonador);
}
