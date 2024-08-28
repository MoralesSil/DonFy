package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Users;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
