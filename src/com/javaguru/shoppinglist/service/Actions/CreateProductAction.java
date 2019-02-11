package com.javaguru.shoppinglist.service.Actions;

import com.javaguru.shoppinglist.domain.Product;
import java.math.BigDecimal;
import java.util.Scanner;

public class CreateProductAction implements Action {

    private static final String ACTION_NAME = "Create Product";

    private final ProductService productService;

    public CreateProductAction(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter product name:");
            String name = scanner.nextLine();

            System.out.println("Enter product price: ");
            String price = scanner.nextLine();

            System.out.println("Enter product category");
            String category = scanner.nextLine();

            System.out.println("Enter product description ");
            String description = scanner.nextLine();

            System.out.println("Enter product discount");
            double discount = scanner.nextDouble();

            Product product = new Product();
            product.setName(name);
            product.setPrice(new BigDecimal(price));
            product.setCategory(category);
            product.setDescription(description);
            product.setDiscount(discount);

            Long response = productService.create(product);
            System.out.println("Response: " + response);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return ACTION_NAME;
    }
}
