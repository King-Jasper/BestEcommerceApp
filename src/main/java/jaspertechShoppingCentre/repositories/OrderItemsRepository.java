package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {
}
