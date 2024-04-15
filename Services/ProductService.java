package Services;

import Models.*;

import javax.swing.*;

public class ProductService {
    public static void showProductOptions(ProductManagementSystem system) {
        String[] options = {"Add Product", "Edit Product", "Remove Product"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Product Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                addProduct(system);
                break;
            case 1:
                editProduct(system);
                break;
            case 2:
                removeProduct(system);
                break;
        }
    }

    private static void addProduct(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        ProductGroup productGroup = findProductGroup(system, groupName);

        if (productGroup != null) {
            String productName = JOptionPane.showInputDialog("Enter the product name:");
            String description = JOptionPane.showInputDialog("Enter the product description:");
            String manufacturer = JOptionPane.showInputDialog("Enter the manufacturer:");

            int quantity = 0;
            while (true) {
                try {
                    quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity:"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid quantity. Please enter a valid integer.");
                }
            }

            double price = 0;
            while (true) {
                try {
                    price = Double.parseDouble(JOptionPane.showInputDialog("Enter the price:"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid price. Please enter a valid number.");
                }
            }

            productGroup.addNewProduct(productName, description, manufacturer, quantity, price);
            JOptionPane.showMessageDialog(null, "Product added successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Product group not found.");
        }
    }

    private static void editProduct(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        ProductGroup productGroup = findProductGroup(system, groupName);

        if (productGroup != null) {
            String productName = JOptionPane.showInputDialog("Enter the product name:");
            Product product = findProduct(productGroup, productName);

            if (product != null) {
                String newProductName = JOptionPane.showInputDialog("Enter the new product name:", product.getProductName());
                String newDescription = JOptionPane.showInputDialog("Enter the new product description:", product.getDescription());
                String newManufacturer = JOptionPane.showInputDialog("Enter the new manufacturer:", product.getManufacturer());
                int newQuantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the new quantity:", product.getQuantity()));
                double newPrice = Double.parseDouble(JOptionPane.showInputDialog("Enter the new price:", product.getPrice()));

                productGroup.editProductInformation(product, newProductName, newDescription, newManufacturer, newQuantity, newPrice);
                JOptionPane.showMessageDialog(null, "Product information updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product group not found.");
        }
    }

    private static void removeProduct(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        ProductGroup productGroup = findProductGroup(system, groupName);

        if (productGroup != null) {
            String productName = JOptionPane.showInputDialog("Enter the product name:");
            Product product = findProduct(productGroup, productName);

            if (product != null) {
                productGroup.removeProduct(product);
                JOptionPane.showMessageDialog(null, "Product removed successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Product not found.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product group not found.");
        }
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