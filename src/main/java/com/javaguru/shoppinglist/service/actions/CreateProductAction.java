package com.javaguru.shoppinglist.service.actions;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;


    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        Product product = new Product();

        getProdutName(product);
        getProductPrice(product);
        getProductCategory(product);
        getProductDescription(product);
        getProductDiscount(product);
        try {
            Long response = productService.create(product);
            System.out.println("Response: " + response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Scanner scanner = new Scanner(System.in);

    void getProdutName(Product product) {

        try {
            System.out.println("Enter product name:");
            String name = scanner.nextLine();
            product.setName(name);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void getProductPrice(Product product) {

        try {
            System.out.println("Enter product price: ");
            String price = scanner.nextLine();
            product.setPrice(new BigDecimal(price));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    void getProductCategory(Product product) {
        System.out.println("Enter product category");
        String category = scanner.nextLine();
        product.setCategory(category);
    }

    void getProductDescription(Product product) {
        System.out.println("Enter product description ");
        String description = scanner.nextLine();
        product.setDescription(description);
    }

    void getProductDiscount(Product product) {

        try{
            System.out.println("Enter product discount");
            double discount = scanner.nextDouble();
            product.setDiscount(discount);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public String toString() {
        return ACTION_NAME;
    }


}
