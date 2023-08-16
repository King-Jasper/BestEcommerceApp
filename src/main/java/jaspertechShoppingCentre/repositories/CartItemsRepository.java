package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    Optional<CartItems> findByProductId(Long productId);
}
