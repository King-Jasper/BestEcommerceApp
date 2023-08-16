package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.OrderRequest;
import jaspertechShoppingCentre.dto.response.AdminOrderResponse;
import jaspertechShoppingCentre.dto.response.OrderResponse;
import jaspertechShoppingCentre.enums.DeliveryStatus;
import org.springframework.data.domain.Page;

public interface OrderService {
    String saveOrder(OrderRequest orderRequest);

    Page<AdminOrderResponse> viewOrderByPaginated(Integer pageNo, Integer pageSize, String sortBy);

    Page<OrderResponse> viewHistory(Integer pageNo, Integer pageSize);

    OrderResponse viewParticularOrder(Long orderId);

    Page<OrderResponse> viewOrderByDeliveryStatus(DeliveryStatus status, Integer pageNo, Integer pageSize);


}
