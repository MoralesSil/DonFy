package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.Donations;

@Repository
public interface IDonationsRepository extends JpaRepository <Donations,Integer>{

}
