package Services;

import Models.*;

import javax.swing.*;
import java.util.List;

public class ProductGroupService {
    public static void addProductGroup(ProductManagementSystemFrame systemFrame) {
        ProductManagementSystem system = systemFrame.getSystem();

        String groupName;
        while(true) {
            groupName = JOptionPane.showInputDialog("Enter the group name:");
            List<String> groupNames = system.getProductGroups().stream().map(ProductGroup::getGroupName).toList();
            if(groupNames.contains(groupName)) {
                JOptionPane.showMessageDialog(systemFrame, "Group name already exists. Please enter a different name.");
            } else {
                break;
            }
        }
        if(groupName == null)
            return;

        String groupDescription = JOptionPane.showInputDialog("Enter the group description:");
        if(groupDescription == null)
            return;

        ProductGroup newGroup = new ProductGroup(groupName, groupDescription);
        system.addProductGroup(newGroup);

        JOptionPane.showMessageDialog(systemFrame, "Product group added successfully.");

        systemFrame.render();
    }

    public static void editProductGroup(ProductManagementSystemFrame systemFrame, ProductGroup productGroup) {
        ProductManagementSystem system = systemFrame.getSystem();

        String newGroupName;
        while(true) {
            newGroupName = JOptionPane.showInputDialog("Enter the new group name:", productGroup.getGroupName());
            List<String> groupNames = system.getProductGroups().stream().map(ProductGroup::getGroupName).toList();
            if(groupNames.contains(newGroupName)) {
                JOptionPane.showMessageDialog(systemFrame, "Group name already exists. Please enter a different name.");
            } else {
                break;
            }
        }
        if(newGroupName == null)
            return;

        String newGroupDescription = JOptionPane.showInputDialog("Enter the new group description:", productGroup.getGroupDescription());
        if(newGroupDescription == null)
            return;

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