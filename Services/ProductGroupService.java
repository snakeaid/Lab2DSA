package Services;

import Models.*;

import javax.swing.*;

public class ProductGroupService {
    public static void showProductGroupOptions(ProductManagementSystem system) {
        String[] options = {"Add Group", "Edit Group", "Remove Group"};
        int choice = JOptionPane.showOptionDialog(null, "Select an option:", "Product Group Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0:
                addProductGroup(system);
                break;
            case 1:
                editProductGroup(system);
                break;
            case 2:
                removeProductGroup(system);
                break;
        }
    }

    private static void addProductGroup(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        String groupDescription = JOptionPane.showInputDialog("Enter the group description:");

        ProductGroup newGroup = new ProductGroup(groupName, groupDescription);
        system.addProductGroup(newGroup);

        JOptionPane.showMessageDialog(null, "Product group added successfully.");
    }

    private static void editProductGroup(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        ProductGroup productGroup = findProductGroup(system, groupName);

        if (productGroup != null) {
            String newGroupName = JOptionPane.showInputDialog("Enter the new group name:", productGroup.getGroupName());
            String newGroupDescription = JOptionPane.showInputDialog("Enter the new group description:", productGroup.getGroupDescription());

            productGroup.setGroupName(newGroupName);
            productGroup.setGroupDescription(newGroupDescription);

            JOptionPane.showMessageDialog(null, "Product group information updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Product group not found.");
        }
    }

    private static void removeProductGroup(ProductManagementSystem system) {
        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        ProductGroup productGroup = findProductGroup(system, groupName);

        if (productGroup != null) {
            system.removeProductGroup(productGroup);
            JOptionPane.showMessageDialog(null, "Product group removed successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Product group not found.");
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
}