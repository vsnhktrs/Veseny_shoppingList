package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private Long TASK_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap <>();

    public Product insert(Product product) {
        product.setId(TASK_ID_SEQUENCE);
        products.put(TASK_ID_SEQUENCE, product);
        TASK_ID_SEQUENCE++;
        return product;

    }

}
