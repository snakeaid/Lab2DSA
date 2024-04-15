package Services;

import Models.*;

import java.io.*;
import javax.swing.*;

public class FileService {
    private static final String FILES_DIRECTORY = "files/";

    public static void saveToFile(ProductManagementSystem system) {
        try {
            FileWriter groupWriter = new FileWriter(FILES_DIRECTORY + "product_groups.txt");
            for (ProductGroup productGroup : system.getProductGroups()) {
                groupWriter.write(productGroup.getGroupName() + "\n");

                writeProductGroupToFile(productGroup);
            }
            groupWriter.close();

            JOptionPane.showMessageDialog(null, "Data saved to files successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data to files.");
            ex.printStackTrace();
        }
    }

    private static void writeProductGroupToFile(ProductGroup productGroup) throws IOException {
        FileWriter productWriter = new FileWriter(FILES_DIRECTORY + productGroup.getGroupName() + ".txt");
        for (Product product : productGroup.getProducts()) {
            productWriter.write("Product Name: " + product.getProductName() + "\n");
            productWriter.write("Description: " + product.getDescription() + "\n");
            productWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
            productWriter.write("Quantity in stock: " + product.getQuantity() + "\n");
            productWriter.write("Price per unit: " + product.getPrice() + "\n\n");
        }

        productWriter.close();
    }
}