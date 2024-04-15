import Models.*;
import Services.FileService;
import Services.ProductManagementGUI;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();

        ProductGroup foodGroup = new ProductGroup("Food Group", "Group for Food Products");
        foodGroup.addProduct(new Product("Flour", "Wheat Flour", "KyivMlyn", 18, 40));
        foodGroup.addProduct(new Product("Buckwheat", "Buckwheat Groats", "Own Line", 7, 20));

        ProductGroup nonFoodGroup = new ProductGroup("Non-Food Group", "Group for Non-Food Products");
        nonFoodGroup.addProduct(new Product("Mug", "Glass Mug", "Bibaboba", 5, 150));
        nonFoodGroup.addProduct(new Product("Markers", "Multicolored Markers", "Crayons", 4, 50));

        system.addProductGroup(foodGroup);
        system.addProductGroup(nonFoodGroup);

        JFrame frame = new JFrame("Product Management System");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        ProductManagementGUI gui = new ProductManagementGUI(system, frame);
        gui.createAndAddButtons();

        JButton saveButton = new JButton("Save Data to File");
        frame.add(saveButton);

        JTextField groupField = new JTextField(20);
        frame.add(new JLabel("Enter Group Name:"));
        frame.add(groupField);

        JButton saveGroupButton = new JButton("Save Group");
        frame.add(saveGroupButton);

        JTextArea logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        frame.add(new JScrollPane(logArea));

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileService.saveToFile(foodGroup);
                FileService.saveToFile(nonFoodGroup);
            }
        });

        saveGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newGroupName = groupField.getText();
                String newGroupDescription = JOptionPane.showInputDialog("Enter the description for the new group:");

                ProductGroup newGroup = new ProductGroup(newGroupName, newGroupDescription);
                system.addProductGroup(newGroup);

                logArea.append("New group added successfully: " + newGroupName + "\n");
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
