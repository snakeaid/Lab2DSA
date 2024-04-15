package Services;

import Models.*;

import java.io.*;
import javax.swing.*;

public class FileService {
    public static void saveToFile(ProductGroup productGroup) {
        try (FileWriter fileWriter = new FileWriter(productGroup.getGroupName() + ".txt")) {
            fileWriter.write("Models.Product Group Name: " + productGroup.getGroupName() + "\n");
            fileWriter.write("Models.Product Group Description: " + productGroup.getGroupDescription() + "\n\n");

            writeProductGroupToFile(productGroup, fileWriter);

            JOptionPane.showMessageDialog(null, "Data saved to file " + productGroup.getGroupName() + ".txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data to file.");
            ex.printStackTrace();
        }
    }

    public static void saveToFile(ProductManagementSystem system) {
        try {
            FileWriter groupWriter = new FileWriter("product_groups.txt");
            for (ProductGroup productGroup : system.getProductGroups()) {
                groupWriter.write(productGroup.getGroupName() + "\n");

                FileWriter productWriter = new FileWriter(productGroup.getGroupName() + ".txt");
                writeProductGroupToFile(productGroup, productWriter);
                productWriter.close();
            }
            groupWriter.close();

            JOptionPane.showMessageDialog(null, "Data saved to files successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data to files.");
            ex.printStackTrace();
        }
    }

    private static void writeProductGroupToFile(ProductGroup productGroup, FileWriter fileWriter) throws IOException {
        for (Product product : productGroup.getProducts()) {
            fileWriter.write("Models.Product Name: " + product.getProductName() + "\n");
            fileWriter.write("Description: " + product.getDescription() + "\n");
            fileWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
            fileWriter.write("Quantity in Stock: " + product.getQuantity() + "\n");
            fileWriter.write("Price per Unit: " + product.getPrice() + "\n\n");
        }
    }
}