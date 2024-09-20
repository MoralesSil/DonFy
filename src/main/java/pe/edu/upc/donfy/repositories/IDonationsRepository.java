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
            "COUNT(D.id_donation) AS total_donativos, " +
            "SUM(D.monto_donado) AS valor_total_estimado, " +
            "COUNT(DISTINCT U.id) AS cantidad_ONG_beneficiadas " +
            "FROM Donations D " +
            "JOIN Users U ON D.users_id_receptor = U.id " +
            "WHERE U.nombreONG IS NOT NULL AND U.nombreONG != ''",
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

    //Listar donativos por Usuario (Como Donador(user) quiero leer los donativos que realice ...)
    @Query("SELECT d " +
            "FROM Donations d " +
            "WHERE d.usersReceptor.id = :userId")
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

}
