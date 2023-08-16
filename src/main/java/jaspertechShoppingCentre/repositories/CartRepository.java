package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.Admin;
import jaspertechShoppingCentre.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Admin.Cart, Long> {
    Optional<Admin.Cart> findByUser(AppUser user);
}
