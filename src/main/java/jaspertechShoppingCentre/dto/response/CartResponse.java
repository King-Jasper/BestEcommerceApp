package jaspertechShoppingCentre.dto.response;

import jaspertechShoppingCentre.entity.CartItems;
import lombok.*;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartResponse {
    String message = "cart is successfully added";
    private List<CartItems> items;
    private Double total;
}
