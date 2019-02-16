package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        double maxDiscount = 100;

        if (product.getDiscount() > maxDiscount) {
            throw new IllegalArgumentException("Discount can't be more then 100%");
        }
    }
}
