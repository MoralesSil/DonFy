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
            "    v.id_comprobante AS comprobante_id, " +
            "    v.fecha_emision AS fecha_emision, " +
            "    v.total AS monto_comprobante, " +
            "    u.nombre AS nombre_donante " +
            "FROM " +
            "    Vouchers v " +
            "JOIN " +
            "    Donations d ON v.id_donativo = d.id_donation " +
            "JOIN " +
            "    Users u ON d.users_id = u.id " +
            "WHERE " +
            "    v.fecha_emision BETWEEN :startDate AND :endDate " +
            "ORDER BY " +
            "    v.fecha_emision ASC", nativeQuery = true)
    List<Object[]> getVouchers(@Param("startDate") String startDate, @Param("endDate") String endDate);

    //HUXX: Gestionar comprobante por Donador (Como donador quiero listar los comprobantes que me emitieron para ... ) A
    @Query("SELECT v.idComprobante, v.descripcion, v.fechaEmision, v.total, v.nombreDonante " +
            "FROM Vouchers v " +
            "JOIN Donations d ON v.donations.idDonation = d.idDonation " +
            "JOIN Users u ON d.users.id = u.id " +
            "WHERE u.nombre = :nombreDonador")
    List<Object[]> findComprobantesByDonador(@Param("nombreDonador") String nombreDonador);


}
