package tdtu.SpringCommerce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import tdtu.SpringCommerce.model.Category;
import tdtu.SpringCommerce.model.Product;
import tdtu.SpringCommerce.model.User;
import tdtu.SpringCommerce.repository.CategoryRepository;
import tdtu.SpringCommerce.repository.ProductRepository;
import tdtu.SpringCommerce.repository.UserRepository;
import tdtu.SpringCommerce.service.user.UserService;

import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            loadDataUsers();
            loadDataCategories();
            loadDataProduct();
        };
    }

    private void loadDataUsers(){
        User user1 = new User();
        user1.setName("Tester");
        user1.setEmail("test@gmail.com");
        user1.setPhoneNumber("1234567890");
        user1.setAddress("Test Street");
        user1.setPassword(passwordEncoder.encode("test"));
        user1.setRole("USER");

        User user2 = new User();
        user2.setName("ADMIN");
        user2.setEmail("admin@gmail.com");
        user2.setPhoneNumber("0793334695");
        user2.setAddress("Admin Street");
        user2.setPassword(passwordEncoder.encode("admin"));
        user2.setRole("ADMIN");

        userRepository.save(user1);
        userRepository.save(user2);
    }

    private void loadDataCategories(){
        Category mobiles = new Category();
        mobiles.setName("Mobile");

        Category laptop = new Category();
        laptop.setName("Laptop");

        Category watch = new Category();
        watch.setName("Watch");

        categoryRepository.save(mobiles);
        categoryRepository.save(laptop);
        categoryRepository.save(watch);
    }

    private void loadDataProduct() {
        Category mobileCategory = categoryRepository.findByName("Mobile").orElseThrow(() -> new RuntimeException("Category not found"));
        Category laptopCategory = categoryRepository.findByName("Laptop").orElseThrow(() -> new RuntimeException("Category not found"));
        Category watchCategory = categoryRepository.findByName("Watch").orElseThrow(() -> new RuntimeException("Category not found"));

        List<Product> products = List.of(
                new Product("Smartphone Elite X", 799.99, "MobileGear", "Black", "A flagship smartphone with cutting-edge features.", "https://via.placeholder.com/150", mobileCategory),
                new Product("Smartphone Lite Z", 599.99, "TechNova", "Blue", "Affordable smartphone with a great camera.", "https://via.placeholder.com/150", mobileCategory),
                new Product("Smartphone Max Pro", 999.99, "MobileX", "Silver", "High-end smartphone with a stunning OLED display.", "https://via.placeholder.com/150", mobileCategory),
                new Product("Ultra Laptop Pro", 1299.99, "TechNova", "Silver", "High-performance laptop for professionals.", "https://via.placeholder.com/150", laptopCategory),
                new Product("Gaming Laptop G7", 1499.99, "GameCraft", "Black", "Designed for gamers with powerful GPU and RGB lighting.", "https://via.placeholder.com/150", laptopCategory),
                new Product("Laptop Slimbook", 899.99, "LightTech", "Gray", "Lightweight laptop for everyday use.", "https://via.placeholder.com/150", laptopCategory),
                new Product("Smart Fitness Watch", 199.99, "FitTime", "Black", "Track your fitness and health metrics in style.", "https://via.placeholder.com/150", watchCategory),
                new Product("Luxury Smartwatch", 399.99, "TimePro", "Gold", "Premium smartwatch with elegant design.", "https://via.placeholder.com/150", watchCategory),
                new Product("Sports Watch Active", 149.99, "RunTime", "Red", "Durable smartwatch for active lifestyles.", "https://via.placeholder.com/150", watchCategory),
                new Product("Smartphone PowerMax", 899.99, "PhoneTech", "White", "Long battery life and fast performance.", "https://via.placeholder.com/150", mobileCategory),
                new Product("Laptop Pro Studio", 1599.99, "CreatorHub", "Black", "Ideal laptop for creative professionals.", "https://via.placeholder.com/150", laptopCategory),
                new Product("Slim Smartwatch", 179.99, "HealthTime", "Silver", "A stylish smartwatch with health tracking features.", "https://via.placeholder.com/150", watchCategory),
                new Product("Smartphone Compact Y", 699.99, "HandyTech", "Green", "Compact design with top-tier performance.", "https://via.placeholder.com/150", mobileCategory),
                new Product("Laptop Budget B", 499.99, "BudgetPC", "Blue", "Affordable laptop with essential features.", "https://via.placeholder.com/150", laptopCategory),
                new Product("Hybrid Smartwatch", 249.99, "TimeBlend", "Brown", "Combines traditional watch design with smart features.", "https://via.placeholder.com/150", watchCategory)
        );

        for (Product product : products) {
            productRepository.save(product);
        }
    }
}