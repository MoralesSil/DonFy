package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Donations;

import java.util.List;

@Repository
public interface IDonationsRepository extends JpaRepository <Donations,Integer>{
    //HU53
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.estado = :estado")
    List<Donations> findDonationsForYourStatus(@Param("estado") String estado);

    //HU34
    @Query(value =
            "SELECT u.nombre AS nombre_donante, " +
                    "d.usersReceptor.nombreONG AS usuario_receptor, " +
                    "SUM(d.montoDonado) AS monto_donado " +
                    "FROM Donations d " +
                    "JOIN Users u ON d.users.id = u.id " +
                    "JOIN DonationType dt ON d.donationType.idTipoDonation = dt.idTipoDonation " +
                    "WHERE dt.nombreTipoDonation = 'monetario' " +
                    "AND YEAR(d.fechaRecojo) = :anio " +
                    "GROUP BY u.nombre, d.usersReceptor.nombreONG")
    List<String[]> resumenDonacionesMonetarias(@Param("anio") int anio);

    //HU37
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.usersReceptor = :ong")
    List<Donations> findDonationsByONG(@Param("ong") String ong);

    //HU39
    @Query(value =
            "SELECT d.idDonation AS id_donativo, d.nombre AS nombre_donativo, " +
                    "d.descripcion AS descripcion, d.estado AS estado, " +
                    "d.fechaRecojo AS fecha_recojo, d.montoDonado AS monto_donado, " +
                    "d.direccionRecojo AS direccion_recojo, " +
                    "p.id AS id_ONG, p.nombreONG AS nombre_ONG " +
                    "FROM Donations d " +
                    "JOIN Users p ON p.id = :idONG " +
                    "JOIN p.roles r " +
                    "WHERE d.idDonation = :idDonation " +
                    "AND r.rol = 'ONG'")
    List<String[]> findDonationAndONGByIds(@Param("idDonation") int idDonation,
                                           @Param("idONG") Long idONG);

    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.donationType.nombreTipoDonation = :typeDonation")
    List<Donations> findDonationsByDonationsType(@Param("typeDonation") String typeDonation);

}

