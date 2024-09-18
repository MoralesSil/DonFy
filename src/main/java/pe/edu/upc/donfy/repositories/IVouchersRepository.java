package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Vouchers;

import java.util.List;

@Repository
public interface IVouchersRepository extends JpaRepository<Vouchers, Integer> {

    // HU53: Generar reporte de comprobante por fecha
    @Query(value = "SELECT " +
            "    c.id_comprobante AS comprobante_id, " +
            "    c.fecha_emision AS fecha_emision, " +
            "    c.total AS monto_comprobante, " +
            "    u.nombre AS nombre_donante " +
            "FROM " +
            "    voucher c " +
            "JOIN " +
            "    Donativo d ON c.id_donativo = d.id_donativo " +
            "JOIN " +
            "    Usuario u ON d.id_usuario = u.id " +
            "WHERE " +
            "    c.fecha_emision BETWEEN :startDate AND :endDate " +
            "ORDER BY " +
            "    c.fecha_emision ASC", nativeQuery = true)
    public List<Object[]> getVouchers(@Param("startDate") String startDate, @Param("endDate") String endDate);

}
