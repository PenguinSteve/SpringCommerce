package tdtu.SpringCommerce.request;

import lombok.Data;

@Data
public class CartItemRequest {
    private Long cartId;
    private Long productId;
    private int quantity;
}
