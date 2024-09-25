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
    @Query(value =
            "SELECT \n" +
                    "\tc.id_comprobante AS id_comprobante,\n" +
                    "    c.fecha_emision AS fecha_emision,  \n" +
                    "    SUM(c.total) AS monto_total \n" +
                    "FROM \n" +
                    "    vouchers c \n" +
                    "GROUP BY \n" +
                    "    c.fecha_emision,\n" +
                    "\tc.id_comprobante\n" +
                    "ORDER BY \n" +
                    "    c.fecha_emision ASC;\n", nativeQuery = true)
    List<String[]> ComprobanteFecha();

    //HU43
    @Query("SELECT c FROM Vouchers c " +
            "JOIN c.donations d " +
            "JOIN d.users u " +
            "WHERE u.id = :userId")
    List<Vouchers> findComprobantesByUserId(@Param("userId") Long userId);

    @Query(value =
            "SELECT " +
                    "c.id_comprobante AS id_comprobante, " +
                    "c.fecha_emision AS fecha_emision, " +
                    "SUM(c.total) AS monto_total " +
                    "FROM " +
                    "vouchers c " +
                    "WHERE DATE(c.fecha_emision) = :fecha " + // Filtra por la fecha que se pasa como parámetro
                    "GROUP BY " +
                    "c.fecha_emision, " +
                    "c.id_comprobante " +
                    "ORDER BY " +
                    "c.fecha_emision ASC", nativeQuery = true)
    List<String[]> ComprobanteFechaPorFecha(@Param("fecha") String fecha);


}

