package Services;

import Models.*;

import javax.swing.*;

public class StatisticsService {
    public static void displayStatistics(ProductManagementSystem system) {
        StringBuilder statistics = new StringBuilder();

        for (ProductGroup group : system.getProductGroups()) {
            statistics.append("Group: ").append(group.getGroupName()).append("\n");
            for (Product product : group.getProducts()) {
                statistics.append("- Product: ").append(product.getProductName()).append("\n");
                statistics.append("  Quantity: ").append(product.getQuantity()).append("\n");
                statistics.append("  Price: ").append(product.getPrice()).append("\n");
                statistics.append("  Total Value: ").append(product.getQuantity() * product.getPrice()).append("\n");
            }
            statistics.append("Total Group Value: ").append(calculateTotalGroupValue(group)).append("\n\n");
        }

        statistics.append("Total Inventory Value: ").append(calculateTotalInventoryValue(system)).append("\n");

        JOptionPane.showMessageDialog(null, statistics.toString());
    }

    private static double calculateTotalGroupValue(ProductGroup group) {
        double totalValue = 0;
        for (Product product : group.getProducts()) {
            totalValue += product.getQuantity() * product.getPrice();
        }
        return totalValue;
    }

    private static double calculateTotalInventoryValue(ProductManagementSystem system) {
        double totalValue = 0;
        for (ProductGroup group : system.getProductGroups()) {
            totalValue += calculateTotalGroupValue(group);
        }
        return totalValue;
    }
}