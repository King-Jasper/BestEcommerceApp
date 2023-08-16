package jaspertechShoppingCentre.service;

import jaspertechShoppingCentre.dto.request.CartRequest;
import jaspertechShoppingCentre.dto.response.CartResponse;

public interface CartService {
    String addItemsToCart(CartRequest cartRequest);

    String  deleteItemsFromCart(Long productId);

    String  addItemsToQuantity(Long productId);


    String reduceItemQuantity(Long productId);

    String  clearCart();

    CartResponse viewCartByUser();
}
