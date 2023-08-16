package jaspertechShoppingCentre.repositories;

import jaspertechShoppingCentre.entity.Order;
import jaspertechShoppingCentre.enums.DeliveryStatus;
import jaspertechShoppingCentre.enums.PickupStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByDeliveryStatus(DeliveryStatus status, Pageable pageable);
    Page<Order>findByUserIdAndPickupStatus(Long UserId, PickupStatus status, Pageable pageable);
}
