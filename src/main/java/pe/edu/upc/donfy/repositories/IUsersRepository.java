package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.donfy.entities.Users;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    public Users findOneByUsername(String username);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    @Query(value = "SELECT u.*\n" +
            " FROM public.users u\n" +
            " JOIN public.roles r ON u.id = r.user_id\n" +
            " WHERE r.rol = 'ONG';",nativeQuery = true)
    public List<Users> rolesONG();

    public Users findUsersByUsername(String username);

    //HU41: Donantes por rango de fecha
    @Query(value = "Select u.nombre, count(*)\n" +
            "From users u\n" +
            "Join donations d on u.id=d.users_id\n" +
            "Join vouchers v on d.id_donation=v.id_donativo\n" +
            "where v.fecha_emision Between TO_TIMESTAMP(:startDate, 'YYYY-MM-DD HH24:MI:SS') And TO_TIMESTAMP(:endDate, 'YYYY-MM-DD HH24:MI:SS')\n" +
            "group by u.nombre", nativeQuery = true)
    public List<String[]> donantesXfechas(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value="SELECT u.saldo FROM users u WHERE u.username = :username", nativeQuery = true)
    public List<Float[]> saldoXusuario(@Param("username") String username);

}
