package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product){
        BigDecimal price = new BigDecimal(String.valueOf(product.getPrice()));

        if (new BigDecimal(String.valueOf(price)).compareTo(BigDecimal.ZERO) <= 0) {
            throw new ProductValidationException("Price must more then 0");
        }
    }
}
