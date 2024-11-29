package tdtu.SpringCommerce.service.cart;

import tdtu.SpringCommerce.model.ShoppingCart;

public interface CartService {
    ShoppingCart getCart(Long id);
    void clearCart(Long id);
    Double getTotalPrice(Long id);
    Long initializeNewCart();
    ShoppingCart getCartByUserId(Long userId);
}
