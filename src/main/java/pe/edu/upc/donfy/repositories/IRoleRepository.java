package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.donfy.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
