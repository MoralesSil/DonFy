package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.donfy.entities.DonationType;

@Repository
public interface IDonationTypeRepository extends JpaRepository<DonationType, Integer> {
}
