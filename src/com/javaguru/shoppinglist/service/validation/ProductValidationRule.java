package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

    default void checkNotNull(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product doesn't exist");
        }
    }

    default void checkIdNotNull(Product product) {
        if (product.getId() == null) {
            throw new ProductValidationException("Id doesn't exist");
        }
    }
}
