import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

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
                saveDataToFile(foodGroup);
                saveDataToFile(nonFoodGroup);
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

    private static void saveDataToFile(ProductGroup productGroup) {
        try (FileWriter fileWriter = new FileWriter(productGroup.getGroupName() + ".txt")) {
            fileWriter.write("Product Group Name: " + productGroup.getGroupName() + "\n");
            fileWriter.write("Product Group Description: " + productGroup.getGroupDescription() + "\n\n");

            for (Product product : productGroup.getProducts()) {
                fileWriter.write("Product Name: " + product.getProductName() + "\n");
                fileWriter.write("Description: " + product.getDescription() + "\n");
                fileWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
                fileWriter.write("Quantity in Stock: " + product.getQuantity() + "\n");
                fileWriter.write("Price per Unit: " + product.getPrice() + "\n\n");
            }

            JOptionPane.showMessageDialog(null, "Data saved to file " + productGroup.getGroupName() + ".txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.");
            ex.printStackTrace();
        }
    }
}
