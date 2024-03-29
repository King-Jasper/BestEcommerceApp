package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.Product;
import jaspertechShoppingCentre.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByProductName(String ProductName);

    List<Product> findByCategory(SubCategory category);

    @Query(value = "SELECT * FROM products WHERE subcategory_id=?", nativeQuery = true)
    List<Product> findAllByCategory_SubCategoryId(Long subcategoryId);

    @Query(value = "SELECT * FROM products WHERE brand_id=?", nativeQuery = true)
    List<Product> findByBrandId(Long brandId);

    @Query(value = "SELECT * FROM products  ORDER BY  createdAt DESC LIMIT 5", nativeQuery = true)
    List<Product> findAllProductByCreatedAtDesc();

    @Query(value = "SELECT * FROM products ORDER BY sale ASC LIMIT 5", nativeQuery = true)
    List<Product> findProductByBestSelling();
}