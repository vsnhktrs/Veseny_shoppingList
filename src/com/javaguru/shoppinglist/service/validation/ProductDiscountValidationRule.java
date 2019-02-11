package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product.getDiscount() > 100) {
            throw new IllegalArgumentException("Discount can't be more then 100%");
        }
    }
}
