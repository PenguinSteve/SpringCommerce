package tdtu.SpringCommerce.Controllers.RestAPIControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ApiProductControllers {

    @GetMapping("/{id}")
    public String product() {
        return "product";
    }
}
