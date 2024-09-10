package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.donfy.entities.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    @Transactional
    @Modifying
    @Query(value="INSERT INTO RolUsuario (nombre, idRolUsuario) VALUES (:rol, :idRole)", nativeQuery = true)
    public void insRol(@Param("rol") String rol, @Param("idRole") Integer idRole);

}
