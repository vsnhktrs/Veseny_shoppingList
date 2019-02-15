package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        int minNameLenght = 3;
        int maxNameLenght = 32;

        if (product.getName().length() < minNameLenght & product.getName().length() > maxNameLenght) {
            throw new ProductValidationException(
                "Product name must have more then 3 and not more then 32 symbols");
        }
    }
}
