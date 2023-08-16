package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.Address;
import jaspertechShoppingCentre.entity.ModeOfPayment;
import jaspertechShoppingCentre.entity.OrderItem;
import jaspertechShoppingCentre.entity.PickupCenter;
import jaspertechShoppingCentre.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.Transaction;

import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Long orderId;
    private ModeOfPayment modeOfPayment;
    private Set<OrderItem> items;
    private Double deliveryFee;

    private DeliveryStatus deliveryStatus;
    private Double grandTotal;
    private Double discount;
    private Address address;
    private Transaction transaction;
    private PickupCenter pickupCenter;
}
