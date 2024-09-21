package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Donations;

import java.util.List;

@Repository
public interface IDonationsRepository extends JpaRepository <Donations,Integer>{
    //HU53- FUNCIONA
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.estado = :estado")
    List<Donations> findDonationsForYourStatus(@Param("estado") String estado);

    //HU34
    @Query("SELECT u.nombre AS nombreDonante, " +
            "d.usersReceptor.nombreONG AS usuarioReceptor, " +
            "SUM(d.montoDonado) AS montoDonado " +
            "FROM Donations d " +
            "JOIN Users u ON d.users.id = u.id " +
            "JOIN DonationType dt ON d.donationType.idTipoDonation = dt.idTipoDonation " +
            "WHERE dt.nombreTipoDonation = 'MONETARIO' " +
            "AND EXTRACT(YEAR FROM d.fechaRecojo) = :anio " +
            "AND u.id = :donadorId " +
            "GROUP BY u.nombre, d.usersReceptor.nombreONG")
    List<String[]> resumenDonacionesMonetariasPorDonador(@Param("anio") int anio, @Param("donadorId") Long donadorId);

    //HU37
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.usersReceptor.id = :ong")
    List<Donations> findDonationsByONG(@Param("ong") int ong);

    //HU39
    @Query("SELECT d.idDonation AS id_donativo, d.nombre AS nombre_donativo, " +
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

    //HU58
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt WHERE d.donationType.nombreTipoDonation = :typeDonation")
    List<Donations> findDonationsByDonationsType(@Param("typeDonation") String typeDonation);

}

