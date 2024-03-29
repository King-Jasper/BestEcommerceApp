package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    boolean existsBySubCategoryName(String name);
    Optional<SubCategory> findBySubCategoryName(String name);

}
