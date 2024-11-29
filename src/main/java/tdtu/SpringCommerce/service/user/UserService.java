package tdtu.SpringCommerce.service.user;

import tdtu.SpringCommerce.model.User;
import tdtu.SpringCommerce.response.AuthResponse;

import java.util.List;

public interface UserService {
    User register(User user);
    AuthResponse verify(User user);
    User getUserById(Long userId);
}
