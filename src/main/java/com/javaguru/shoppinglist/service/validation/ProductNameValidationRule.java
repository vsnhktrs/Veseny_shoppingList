package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        int minNameLetters = 3;
        int maxNameLetters = 32;

        if (product.getName().length() < minNameLetters | product.getName().length() > maxNameLetters) {
            throw new ProductValidationException(
                "Product name must have more then 3 and not more then 32 symbols");
        }
    }
}
