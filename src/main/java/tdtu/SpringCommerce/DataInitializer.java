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
                // Mobile
                new Product("Smartphone Nova A1", 699.99, "TechNova", "Black", "Affordable smartphone with solid performance.", "https://cdn.tgdd.vn/Products/Images/42/118143/huawei-nova-2i-hh-600x600-600x600.jpg", mobileCategory),
                new Product("Smartphone Gear X", 799.99, "MobileGear", "White", "A premium smartphone for tech enthusiasts.", "https://cdn.tgdd.vn/Products/Images/42/113572/xiaomi-mi-a1-vang-hong-600x600.jpg", mobileCategory),
                new Product("Smartphone Lite B", 599.99, "TechNova", "Blue", "Lightweight smartphone with sleek design.", "https://cdn.tgdd.vn/Products/Images/42/317530/samsung-galaxy-a05s-sliver-thumbnew-600x600.jpg", mobileCategory),

                // Laptop
                new Product("Laptop Ultra Nova", 1299.99, "TechNova", "Black", "High-performance laptop for professionals.", "https://cdn.tgdd.vn/Products/Images/44/323325/hp-240-g10-i5-9h2e4pt-thumb-600x600.jpg", laptopCategory),
                new Product("Gaming Laptop XG", 1499.99, "MobileGear", "White", "A gaming laptop with stunning graphics.", "https://cdn.tgdd.vn/Products/Images/44/327408/hp-probook-450-g10-i7-9h8h1pt-thumb-600x600.jpg", laptopCategory),
                new Product("Laptop Slim Nova", 899.99, "TechNova", "Blue", "Ultra-slim laptop with excellent portability.", "https://cdn.tgdd.vn/Products/Images/44/325050/acer-swift-go-14-ai-73-53x7-ultra-5-nxkslsv001-thumb-600x600.jpg", laptopCategory),

                // Watch
                new Product("Fitness Watch FitPro", 199.99, "FitTime", "Black", "Track your fitness metrics accurately.", "https://cdn.tgdd.vn/Products/Images/7077/248752/samsung-galaxy-watch-4-40mm-tn-2-600x600.jpg", watchCategory),
                new Product("Luxury Watch GearTime", 399.99, "MobileGear", "White", "A stylish smartwatch with premium features.", "https://cdn.tgdd.vn/Products/Images/7264/293584/orient-ra-aa0812l19b-nam-thumb-600x600.jpg", watchCategory),
                new Product("Smart Watch NovaFit", 249.99, "TechNova", "Blue", "A feature-packed smartwatch for everyday use.", "https://cdn.tgdd.vn/Products/Images/7264/199608/g-shock-ga-710gb-1adr-den-thumb-600x600.jpg", watchCategory)
        );

        productRepository.saveAll(products);
    }
}