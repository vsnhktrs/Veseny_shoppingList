package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.productIdSequence;
import com.javaguru.shoppinglist.service.actions.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductService implements ProductService {

    private productIdSequence repository = new productIdSequence();
    private ProductValidationService validationService = new ProductValidationService();

    public Long create(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.add(product);
        return createdProduct.getId();
    }

    public Product findBy(Long id) {
        return repository.findId(id);
    }
}

