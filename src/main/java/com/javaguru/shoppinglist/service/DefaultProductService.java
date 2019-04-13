package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductRepasitory;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepasitory repasitory;
    private final ProductValidationService validationService;

    @Autowired
    public DefaultProductService(ProductRepasitory repasitory,
                                 ProductValidationService validationService) {
        this.repasitory = repasitory;
        this.validationService = validationService;
    }

    @Transactional
    public Long create(Product product) {
        validationService.validate(product);
        return repasitory.insert(product);
    }

    public Product findProductById(Long id) {
        return repasitory.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found, id: " + id));
    }

    @Transactional
    public Long delete(Long id) {
        return repasitory.delete(id);
    }

    @Transactional
    public Long update(Product product) {
        validationService.validate(product);
        return repasitory.update(product);
    }
}

