package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Vouchers;

import java.util.List;

@Repository
public interface IVouchersRepository extends JpaRepository<Vouchers, Integer> {

    @Query(value =
            "SELECT c.idComprobante AS id_comprobante, " +
                    "c.fechaEmision AS fecha_emision, " +
                    "c.total AS total, " +
                    "u.nombre AS nombre_donante, " +
                    "c.descripcion AS descripcion, " +
                    "d AS donations " +
                    "FROM Vouchers c " +
                    "JOIN c.donations d " +
                    "JOIN d.users u " +
                    "WHERE u.id = :userId")
    List<Vouchers> findComprobantesByUserId(@Param("userId") Long userId);


}
