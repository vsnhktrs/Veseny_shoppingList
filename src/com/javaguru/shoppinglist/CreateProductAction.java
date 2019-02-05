package com.javaguru.shoppinglist;

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

        System.out.println("Enter product name:");
        String name = scanner.nextLine();

        if (name.length() < 3 || name.length() > 32) {
            throw new IllegalArgumentException("Product name must be at least 3 symbols, and not mote then 32 symbols");
        }

        System.out.println("Enter product price: ");
        String price = scanner.nextLine();

        BigDecimal zero = new BigDecimal(0);
        if (new BigDecimal(price).compareTo(zero) <= 0) {
            throw new IllegalArgumentException("Price must more then 0");
        }

        System.out.println("Enter product category");
        String category = scanner.nextLine();

        System.out.println("Enter product description ");
        String description = scanner.nextLine();

        System.out.println("Enter product discount");
        double discount = scanner.nextDouble();

        if (discount > 100) {
            throw new IllegalArgumentException("Discount can't be more then 100%");
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(new BigDecimal(price));
        product.setCategory(category);
        product.setDescription(description);
        product.setDiscount(discount);

        try {
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
