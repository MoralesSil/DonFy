package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.donfy.entities.DonationType;

public interface IDonationTypeRepository extends JpaRepository<DonationType, Integer> {
}
