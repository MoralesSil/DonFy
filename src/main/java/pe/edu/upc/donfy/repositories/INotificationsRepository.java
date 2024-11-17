package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Notifications;

import java.util.List;

@Repository
public interface INotificationsRepository extends JpaRepository<Notifications, Integer> {
    @Query(value = "SELECT n.* " +
            "FROM Notifications n " +
            "JOIN Users u ON n.users_id = u.id " +
            "WHERE u.id = :userId", nativeQuery = true)
    List<Notifications> findNotificationsByUserId(@Param("userId") Long userId);

    @Query(value = "SELECT n.* " +
            "FROM Notifications n " +
            "JOIN Users u ON n.users_id = u.id " +
            "WHERE u.username = :username " +
            "AND u.rol = 'DONADOR'", nativeQuery = true)
    List<Notifications> findNotificationsByUsername(@Param("username") String username);

    @Query(value = "SELECT n.* " +
            "FROM Notifications n " +
            "JOIN Users u ON n.users_id = u.id " +
            "WHERE u.username = :username " +
            "AND u.rol = 'ONG'", nativeQuery = true)
    List<Notifications> findNotificationsByUsernameONG(@Param("username") String username);

}
