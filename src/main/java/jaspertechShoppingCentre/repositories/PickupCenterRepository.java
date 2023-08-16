package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.PickupCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PickupCenterRepository extends JpaRepository<PickupCenter, Long> {
    Optional<PickupCenter> findByEmail(String email);
}
