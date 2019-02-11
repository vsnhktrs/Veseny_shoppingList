package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product){
        BigDecimal zero = new BigDecimal(0);
        BigDecimal price = new BigDecimal(String.valueOf(product.getPrice()));

        if (new BigDecimal(String.valueOf(price)).compareTo(zero) <= 0) {
            throw new IllegalArgumentException("Price must more then 0");
        }
    }
}
