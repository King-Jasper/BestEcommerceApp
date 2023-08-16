package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleName(String Customer);
}
