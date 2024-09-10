package pe.edu.upc.donfy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.donfy.entities.Vouchers;

public interface IVouchersRepository extends JpaRepository<Vouchers, Integer> {
}
