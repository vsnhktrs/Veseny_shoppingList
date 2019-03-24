package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Profile;

@Profile("inmemorydb")
public class ProductIdSequence implements ProductRepasitory {

    private Long TASK_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Long add(Product product) {
        product.setId(TASK_ID_SEQUENCE++);
        products.put(product.getId(), product);
        return product.getId();
    }

    public Optional<Product> findby(Long id) {
        return Optional.ofNullable(products.get(id));
    }
}
