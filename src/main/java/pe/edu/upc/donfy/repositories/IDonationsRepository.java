package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Donations;

import java.util.List;

@Repository
public interface IDonationsRepository extends JpaRepository <Donations,Integer>{
    //Filtrar donativos físicos por su estado
    @Query("SELECT d.usersReceptor.nombreONG, d.fotoDonativo, d.fechaRecojo, d.estado FROM Donations d " +
            "JOIN d.donationType dt WHERE dt.nombreTipoDonation = 'físico' AND d.estado = :estado")
    List<String[]> findDonationsByEstadoAndTipoFisico(@Param("estado") String estado);

    //Mostrar el total donado para cada ONG
    @Query(value =
            "SELECT u.nombre AS nombre_donante, " +
                    "d.usersReceptor.nombreONG AS usuario_receptor, " +
                    "SUM(d.montoDonado) AS monto_donado " +
                    "FROM Donations d " +
                    "JOIN Users u ON d.users.id = u.id " +
                    "JOIN DonationType dt ON d.donationType.idTipoDonation = dt.idTipoDonation " +
                    "WHERE dt.nombreTipoDonation = 'monetario' " +
                    "GROUP BY u.nombre, d.usersReceptor.nombreONG")
    List<String[]> resumenDonacionesMonetarias();

    //Mostrar las tendencias de donaciones
    @Query(value = "SELECT dt.nombre_tipo_donation AS tipo_donacion, DATE_TRUNC('month', d.fecha_recojo) AS mes,\n" +
            " COUNT(d.id_donation) AS total_donaciones\n" +
            " FROM donations d\n" +
            " JOIN donation_type dt ON d.tipo_donativo_id = dt.id_tipo_donation\n" +
            " WHERE d.fecha_recojo >= CURRENT_DATE - INTERVAL '6 months'\n" +
            " GROUP BY dt.nombre_tipo_donation, DATE_TRUNC('month', d.fecha_recojo)",nativeQuery = true)
    List<String[]> tendenciasDonacionesMeses();

}
