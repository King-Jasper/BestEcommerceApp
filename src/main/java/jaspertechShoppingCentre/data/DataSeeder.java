package jaspertechShoppingCentre.data;

import jaspertechShoppingCentre.entity.Role;
import jaspertechShoppingCentre.repositories.RoleRepository;
import jaspertechShoppingCentre.utils.Permission;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role adminRole = new Role();
        adminRole.setRoleName("ADMIN");
        adminRole.setPermissions(
                List.of(
                        Permission.ADMIN_CREATE,
                        Permission.ADMIN_READ,
                        Permission.ADMIN_UPDATE,
                        Permission.ADMIN_DELETE,
                        Permission.CUSTOMER_CREATE,
                        Permission.CUSTOMER_READ,
                        Permission.CUSTOMER_UPDATE,
                        Permission.CUSTOMER_DELETE
                ));

        Role customerRole = new Role();
        adminRole.setRoleName("CUSTOMER");
        customerRole.setPermissions(
                List.of(
                        Permission.CUSTOMER_CREATE,
                        Permission.CUSTOMER_READ,
                        Permission.CUSTOMER_UPDATE,
                        Permission.CUSTOMER_DELETE
                ));

        roleRepository.save(adminRole);
        roleRepository.save(customerRole);
    }
}
