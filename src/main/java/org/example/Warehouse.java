package org.example;

import java.util.HashMap;
import java.util.Map;

class Warehouse {
    private final Map<String, Product> products;

    public Warehouse() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, int initialQuantity) {
        if (products.containsKey(name)) {
            Product existingProduct = products.get(name);
            existingProduct.setQuantity(existingProduct.getQuantity() + initialQuantity);
        } else {
            Product newProduct = new Product(name, initialQuantity);
            products.put(name, newProduct);
        }
    }

    public void displayStock() {
        System.out.println("Warehouse Stock:");
        if (products.isEmpty()) {
            System.out.println("No products in stock.");
        } else {
            for (Map.Entry<String, Product> entry : products.entrySet()) {
                Product product = entry.getValue();
                int quantity = product.getQuantity();
                System.out.println(product.getName() + ": " + (quantity == 0 ? "0" : quantity));
            }
        }
    }
    public void processOrder(String name, int orderedQuantity) {
        if (products.containsKey(name)) {
            Product product = products.get(name);
            if (product.getQuantity() >= orderedQuantity) {
                product.setQuantity(product.getQuantity() - orderedQuantity);
                System.out.println("Order processed: " + orderedQuantity + " units of " + name);
            } else {
                System.out.println("Insufficient stock for product: " + name);
            }
        } else {
            System.out.println("Product not found: " + name);
        }
    }
}