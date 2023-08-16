package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
boolean existByBrandName(String BrandName);

Optional<Brand> findByBrandName(String brandName);
}
