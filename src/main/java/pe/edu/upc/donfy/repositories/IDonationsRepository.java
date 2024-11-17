package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.dtos.DonationsDTO;
import pe.edu.upc.donfy.entities.Donations;

import java.util.List;

@Repository
public interface IDonationsRepository extends JpaRepository <Donations,Integer>{

    @Query("SELECT COUNT(d.idDonation) " +
            "FROM Donations d " +
            "WHERE d.eliminado = false " +
            "AND MONTH(d.fechaRecojo) = :mes " +
            "AND d.donationType.idTipoDonation = 1")
    List<String[]> obtenerCantidadDonativosFisicosPorMes(@Param("mes") int mes);


    //Listar donativos sin los eliminados -- No tiene HU
    @Query("SELECT d FROM Donations d WHERE d.eliminado = false")
    List<Donations> findAllActiveDonations();

    //Listar donativos de donador - No tiene HU
    @Query("SELECT d FROM Donations d " +
            "JOIN Role r ON d.users.id = r.user.id " +
            "JOIN Users u ON r.user.id = u.id " +
            "WHERE u.username = :username AND r.rol = 'DONADOR'")
    List<Donations> findDonationsByUserIdAndRole(String username);

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
            "AND u.username = :username " +
            "GROUP BY u.nombre, d.usersReceptor.nombreONG")
    List<String[]> resumenDonacionesMonetariasPorDonador(@Param("anio") int anio, @Param("username") String username);

    //HU37 --->buscaba por id, ahora busca por username
    @Query("SELECT d FROM Donations d " +
            "JOIN d.donationType dt " +
            "JOIN d.usersReceptor ur WHERE ur.username = :ongUsername")
    List<Donations> findDonationsByONG(@Param("ongUsername") String ongUsername);

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


    //Mostrar las tendencias de donaciones
    @Query(value = "SELECT dt.nombre_tipo_donation AS tipo_donacion, TO_CHAR(DATE_TRUNC('month', d.fecha_recojo), 'YYYY-MM-DD') AS mes,\n" +
            " COUNT(d.id_donation) AS total_donaciones\n" +
            " FROM donations d\n" +
            " JOIN donation_type dt ON d.tipo_donativo_id = dt.id_tipo_donation\n" +
            " WHERE d.fecha_recojo >= CURRENT_DATE - INTERVAL '6 months'\n" +
            " GROUP BY dt.nombre_tipo_donation, DATE_TRUNC('month', d.fecha_recojo)", nativeQuery = true)
    List<String[]> tendenciasDonacionesMeses();



    //Ver el estado de mi donación física de un usuario en específico
    @Query("SELECT d " +
            "FROM Donations d" +
            " JOIN d.users u " +
            "JOIN d.donationType dt" +
            " WHERE u.id = :users_id_receptor" +
            " AND dt.nombreTipoDonation = 'fisico'" +
            " AND d.estado IN ('Pendiente', 'En proceso', 'Recogido')")
    List<Donations> findPhysicalDonationsByUserIdAndStatus(@Param("users_id_receptor") Long Users_id_receptor);

    //Visualizar estadisticas de las donaciones
    @Query(value = "SELECT " +
            "U.nombreONG AS nombreONG, " +
            "COUNT(D.id_donation) AS total_donativos, " +
            "SUM(D.monto_donado) AS valor_total_estimado " +
            "FROM Donations D " +
            "JOIN Users U ON D.users_id_receptor = U.id " +
            "WHERE U.nombreONG IS NOT NULL AND U.nombreONG != '' " +
            "GROUP BY U.nombreONG " +
            "ORDER BY U.nombreONG",
            nativeQuery = true)
    List<String[]> getDonationStatistics();


    //HU29: Generar Reporte de historial de donaciones

    @Query(value = "SELECT " +
            "    d.nombre AS nombreDonativo, " +
            "    d.monto_donado AS montoDonado, " +
            "    d.fecha_recojo AS fechaRecojo, " +
            "    d.estado AS estadoDonacion, " +
            "    u.nombre AS nombreDonante " +
            "FROM " +
            "    donations d " +
            "JOIN " +
            "    Users u ON d.Users_id = u.id " +
            "ORDER BY " +
            "    d.fecha_recojo DESC", nativeQuery = true)
    public List<DonationsDTO> getDonations();

    //Listar donativos por Usuario
    @Query("SELECT d FROM Donations d " +
            "JOIN d.users u " +
            "WHERE u.id = :userId AND 'DONADOR' IN (SELECT r.rol FROM u.roles r) " +
            "ORDER BY d.fechaRecojo DESC")
    List<Donations> findByUserId(@Param("userId") Long userId);

    //HU42: Listar personas con más donaciones según el tipo de donativo
    @Query(value = "SELECT DISTINCT ON (dt.nombre_tipo_donation) \n" +
            "       u.nombre, \n" +
            "       dt.nombre_tipo_donation, \n" +
            "       COUNT(d.*) AS Total_donaciones\n" +
            "FROM donations d \n" +
            "INNER JOIN users u ON d.users_id = u.id\n" +
            "INNER JOIN donation_type dt ON d.tipo_donativo_id = dt.id_tipo_donation\n" +
            "GROUP BY u.nombre, dt.nombre_tipo_donation\n" +
            "ORDER BY dt.nombre_tipo_donation, Total_donaciones DESC;",nativeQuery = true)
    List<String[]>personasConMaxDonaciones();


    //Monto anual por cada ONG
    @Query(value = "SELECT " +
            "u.nombreONG AS nombreONG, " +
            "SUM(d.monto_donado) AS totalDonadoEnElAno " +
            "FROM Donations d " +
            "JOIN Users u ON d.Users_Id_Receptor = u.id " +
            "WHERE EXTRACT(YEAR FROM d.fecha_recojo) = :year " +  // Cambio aquí para usar un parámetro
            "AND u.nombreONG IS NOT NULL " +
            "GROUP BY u.nombreONG " +
            "ORDER BY SUM(d.monto_donado) DESC",
            nativeQuery = true)
    List<String[]> obtenerTotalDonadoPorONG(@Param("year") int year);
}
