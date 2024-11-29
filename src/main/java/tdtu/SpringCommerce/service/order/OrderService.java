package tdtu.SpringCommerce.service.order;

import tdtu.SpringCommerce.dto.OrderDTO;
import tdtu.SpringCommerce.model.Orders;
import tdtu.SpringCommerce.request.PlaceOrderRequest;

import java.util.List;

public interface OrderService {
    Orders placeOrder(Long userId, String address);
//    OrderDTO getOrder(Long orderId);
//    List<OrderDTO> getUserOrders(Long userId);

    Orders placeOrderGuest(PlaceOrderRequest request);
}
