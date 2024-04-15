import Models.*;
import Services.FileService;
import Models.ProductManagementSystemFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        ProductManagementSystem system = new ProductManagementSystem();
        seedSystem(system);
        ProductManagementSystemFrame inventoryFrame = new ProductManagementSystemFrame(system);
    }

    private static void seedSystem(ProductManagementSystem system) {
        ProductGroup foodGroup = new ProductGroup("Food", "Group for food products");
        foodGroup.addProduct(new Product("Flour", "Wheat Flour", "KyivMlyn", 18, 40));
        foodGroup.addProduct(new Product("Buckwheat", "Buckwheat Groats", "Own Line", 7, 20));

        ProductGroup nonFoodGroup = new ProductGroup("Non-Food", "Group for non-food products");
        nonFoodGroup.addProduct(new Product("Mug", "Glass Mug", "Bibaboba", 5, 150));
        nonFoodGroup.addProduct(new Product("Markers", "Multicolored Markers", "Crayons", 4, 50));

        system.addProductGroup(foodGroup);
        system.addProductGroup(nonFoodGroup);
    }
}
