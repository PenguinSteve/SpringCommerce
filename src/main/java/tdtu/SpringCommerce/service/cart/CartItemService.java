package tdtu.SpringCommerce.service.cart;

import tdtu.SpringCommerce.model.CartItem;
import tdtu.SpringCommerce.request.CartItemRequest;

public interface CartItemService {
    void addItemToCart(Long cartId, Long productId, int quantity);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemQuantity(Long cartId, Long productId, int quantity);
    CartItem getCartItem(Long cartId, Long productId);
}
