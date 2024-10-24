package org.example.lab6_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProductConfig {

    @Bean
    @Scope("prototype")
    public Product product1() {
        Product product = new Product();
        product.setId(1);
        product.setName("Product A");
        product.setPrice(100.50);
        product.setDescription("Description of Product A");
        return product;
    }

    @Bean
    @Scope("prototype")
    public Product product2() {
        return new Product(2, "Product B", 200.75, "Description of Product B");
    }

    @Bean
    public Product product3() {
        return new Product(3, "Product C", 300.25, "Description of Product C");
    }
}

