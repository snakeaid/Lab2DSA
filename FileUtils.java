import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

class FileUtils {
    public static void saveDataToFile(ProductManagementSystem system) {
        try {
            FileWriter groupWriter = new FileWriter("product_groups.txt");
            for (ProductGroup productGroup : system.getProductGroups()) {
                groupWriter.write(productGroup.getGroupName() + "\n");

                FileWriter productWriter = new FileWriter(productGroup.getGroupName() + ".txt");
                for (Product product : productGroup.getProducts()) {
                    productWriter.write("Product Name: " + product.getProductName() + "\n");
                    productWriter.write("Description: " + product.getDescription() + "\n");
                    productWriter.write("Manufacturer: " + product.getManufacturer() + "\n");
                    productWriter.write("Quantity in Stock: " + product.getQuantity() + "\n");
                    productWriter.write("Price per Unit: " + product.getPrice() + "\n\n");
                }
                productWriter.close();
            }
            groupWriter.close();

            JOptionPane.showMessageDialog(null, "Data saved to files successfully.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error saving data to files.");
            ex.printStackTrace();
        }
    }
}