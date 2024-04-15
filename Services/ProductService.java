package Services;

import Models.*;

import javax.swing.*;

public class ProductService {
    public static void addProduct(ProductManagementSystemFrame systemFrame, ProductGroup productGroup) {
        String productName = JOptionPane.showInputDialog("Enter the product name:");
        String description = JOptionPane.showInputDialog("Enter the product description:");
        String manufacturer = JOptionPane.showInputDialog("Enter the product manufacturer:");

        int quantity = 0;
        while (true) {
            try {
                quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity:"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(systemFrame, "Invalid quantity. Please enter a valid integer.");
            }
        }

        double price = 0;
        while (true) {
            try {
                price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price:"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(systemFrame, "Invalid price. Please enter a valid number.");
            }
        }

        productGroup.addNewProduct(productName, description, manufacturer, quantity, price);
        JOptionPane.showMessageDialog(null, "Product added successfully.");

        systemFrame.render();
    }

    public static void editProduct(ProductManagementSystemFrame systemFrame, Product product) {
        String newProductName = JOptionPane.showInputDialog("Enter the new product name:", product.getProductName());
        String newDescription = JOptionPane.showInputDialog("Enter the new product description:", product.getDescription());
        String newManufacturer = JOptionPane.showInputDialog("Enter the new manufacturer:", product.getManufacturer());

        int newQuantity = 0;
        while (true) {
            try {
                newQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the new quantity:"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(systemFrame, "Invalid quantity. Please enter a valid integer.");
            }
        }

        double newPrice = 0;
        while (true) {
            try {
                newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the new price:"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(systemFrame, "Invalid price. Please enter a valid number.");
            }
        }

        product.setProductName(newProductName);
        product.setDescription(newDescription);
        product.setManufacturer(newManufacturer);
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);

        JOptionPane.showMessageDialog(systemFrame, "Product information updated successfully.");

        systemFrame.render();
    }

    public static void removeProduct(ProductManagementSystemFrame systemFrame, ProductGroup productGroup, Product product) {
        productGroup.removeProduct(product);

        JOptionPane.showMessageDialog(systemFrame, "Product removed successfully.");

        systemFrame.render();
    }

    public static void searchProduct(ProductManagementSystem system) {
        String productName = JOptionPane.showInputDialog("Enter the product name:");
        boolean found = false;

        for (ProductGroup group : system.getProductGroups()) {
            Product product = findProduct(group, productName);
            if (product != null) {
                found = true;
                JOptionPane.showMessageDialog(null, "Product found in group: " + group.getGroupName());
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Product not found in any group.");
        }
    }

    private static ProductGroup findProductGroup(ProductManagementSystem system, String groupName) {
        for (ProductGroup group : system.getProductGroups()) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        return null;
    }

    private static Product findProduct(ProductGroup group, String productName) {
        for (Product product : group.getProducts()) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }
}