package tdtu.SpringCommerce.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UpdateProductRequest {
    private String name;
    private Double price;
    private String brand;
    private String color;
    private String description;
    private MultipartFile imageURL;
    private String category;
}
