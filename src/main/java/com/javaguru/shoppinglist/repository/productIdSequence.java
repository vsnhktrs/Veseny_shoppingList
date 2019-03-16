package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class productIdSequence  {

    private Long TASK_ID_SEQUENCE = 0L;
    private Map<Long, Product> products = new HashMap<>();

    public Long add(Product product) {
//        product.setId(TASK_ID_SEQUENCE);
//        products.put(TASK_ID_SEQUENCE, product);
//        TASK_ID_SEQUENCE++;
//        return product;
    product.setId(TASK_ID_SEQUENCE++);
    products.put(product.getId(), product);
    return product.getId();
    }

    public Product findId(Long id) {
        return products.get(id);
    }

//    public Long add(Product product){
//        product.setId(TASK_ID_SEQUENCE++);
//        products.put(product.getId(), product);
//        return product.getId();
//    }
//
//    public Optional<Product> findId(Long id){
//        return Optional.ofNullable(products.get(id));
//    }

}
