package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0 && productRepository.count() == 0) {
            // create categories
            Category electronics = new Category();
            electronics.setName("Electronics");
    
            Category clothing = new Category();
            clothing.setName("Clothing");
    
            Category home = new Category();
            home.setName("Home and Kitchen");
    
            categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));
    
            // create products
    
            Product phone = new Product();
            phone.setName("Smart Phone");
            phone.setDescription("Latest model smart phone with amazing features");
            phone.setImageUrl("https://images.pexels.com/photos/892757/pexels-photo-892757.jpeg?cs=srgb&dl=hands-woman-smartphone-892757.jpg&fm=jpg");
            phone.setPrice(699.99);
            phone.setCategory(electronics);
    
            Product laptop = new Product();
            laptop.setName("Laptop");
            laptop.setDescription("High Performance Laptop for work and personal uses");
            laptop.setImageUrl("https://b2c-contenthub.com/wp-content/uploads/2023/06/Dell-XPS-17-9730-overview.jpg?resize=1536%2C1152&quality=50&strip=all");
            laptop.setPrice(1199.99);
            laptop.setCategory(electronics);
    
            Product jacket = new Product();
            jacket.setName("Winter Jacket");
            jacket.setDescription("Warm and cozy jacket for Winter");
            jacket.setImageUrl("https://tse4.mm.bing.net/th/id/OIP.6UrAtPvtIQs2j2ARAwCwpQHaHa?rs=1&pid=ImgDetMain&o=7&rm=3");
            jacket.setPrice(129.99);
            jacket.setCategory(clothing);
    
            Product blender = new Product();
            blender.setName("Blender");
            blender.setDescription("Best for smoothies and juices");
            blender.setImageUrl("https://m.media-amazon.com/images/I/712bzMmtRpL._AC_SL1500_.jpg");
            blender.setPrice(59.99);
            blender.setCategory(home);
    
            productRepository.saveAll(Arrays.asList(phone, laptop, jacket, blender));
        }
    }
}
