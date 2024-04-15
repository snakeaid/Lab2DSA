package Services;

import Models.*;

import javax.swing.*;

public class ProductGroupService {
    public static void addProductGroup(ProductManagementSystemFrame systemFrame) {
        ProductManagementSystem system = systemFrame.getSystem();

        String groupName = JOptionPane.showInputDialog("Enter the group name:");
        String groupDescription = JOptionPane.showInputDialog("Enter the group description:");

        ProductGroup newGroup = new ProductGroup(groupName, groupDescription);
        system.addProductGroup(newGroup);

        JOptionPane.showMessageDialog(systemFrame, "Product group added successfully.");

        systemFrame.render();
    }

    public static void editProductGroup(ProductManagementSystemFrame systemFrame, ProductGroup productGroup) {
        String newGroupName = JOptionPane.showInputDialog("Enter the new group name:", productGroup.getGroupName());
        String newGroupDescription = JOptionPane.showInputDialog("Enter the new group description:", productGroup.getGroupDescription());

        productGroup.setGroupName(newGroupName);
        productGroup.setGroupDescription(newGroupDescription);

        JOptionPane.showMessageDialog(systemFrame, "Product group information updated successfully.");

        systemFrame.render();
    }

    public static void removeProductGroup(ProductManagementSystemFrame systemFrame, ProductGroup productGroup) {
        ProductManagementSystem system = systemFrame.getSystem();

        system.removeProductGroup(productGroup);
        JOptionPane.showMessageDialog(systemFrame, "Product group removed successfully.");

        systemFrame.render();
    }
}