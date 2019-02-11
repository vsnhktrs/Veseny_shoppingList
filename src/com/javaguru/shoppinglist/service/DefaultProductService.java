package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import java.util.HashMap;
import java.util.Map;

public class DefaultProductService implements ProductService {

    private ProductRepository repository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService();

    private Map<Long, Product> database = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;

    public Product findBy(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id must be not null");
        }
        return database.get(id);
    }

    @Override
    public Long create(Product product) {
//        if (product == null) {
//            throw new IllegalArgumentException("Cannot be null");
//        }
        validationService.validate(product);
        Product createdProduct = repository.insert(product);


        return createdProduct.getId();
    }

}
