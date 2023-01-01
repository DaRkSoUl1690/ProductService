package com.example.ProductService.command.api.events;

import com.example.ProductService.command.api.data.Product;
import com.example.ProductService.command.api.repository.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    public ProductEventsHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product =
                new Product();
        BeanUtils.copyProperties(event, product);
        productRepository.save(product);
    }
}
