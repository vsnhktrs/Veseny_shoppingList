package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ProductValidationException("error productname");
        } else if (product.getName().length() < 3) {
            throw new ProductValidationException(
                "Product name must have more then 3 and not more then 32 symbols");
        }

    }

}
