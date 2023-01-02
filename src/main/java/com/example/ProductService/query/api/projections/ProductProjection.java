package com.example.ProductService.query.api.projections;

import com.example.ProductService.command.api.data.Product;
import com.example.ProductService.command.api.model.ProductRestModel;
import com.example.ProductService.command.api.repository.ProductRepository;
import com.example.ProductService.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductProjection {

    private ProductRepository productRepository;


    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery) {
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModel> productRestModels =
                products.stream()
                        .map(product -> ProductRestModel
                                .builder()
                                .name(product.getName())
                                .price(product.getPrice())
                                .quantity(product.getQuantity())
                                .build()
                        ).toList();

        return productRestModels;
    }
}
