package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.donfy.entities.Users;

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

// BUSCAR ONG POR UBICACION
    @Query(value = "SELECT u.nombreONG AS nombre, u.direccion AS direccion " +
            "FROM Users u " +
            "WHERE u.direccion LIKE %:direccion% AND u.nombreONG IS NOT NULL", nativeQuery = true)
    List<Users> findONGsByAddressPattern(@Param("direccion")String direccion);


}
