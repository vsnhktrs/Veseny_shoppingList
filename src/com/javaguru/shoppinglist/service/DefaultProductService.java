package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepository;
import com.javaguru.shoppinglist.service.Actions.ProductService;
import com.javaguru.shoppinglist.service.validation.ProductDiscountValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationRule;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

public class DefaultProductService implements ProductService {

    private ProductRepository repository = new ProductRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long create(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.adding(product);
        return createdProduct.getId();
    }

    public Product findBy(Long id) {
        return repository.findId(id);
    }
}

