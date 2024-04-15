package Models;

import Services.ProductGroupService;
import Services.ProductService;

import javax.swing.*;
import java.awt.*;

public class ProductGroupTitleRowPanel extends JPanel {
    private ProductManagementSystemFrame systemFrame;
    private ProductGroup productGroup;

    public ProductGroupTitleRowPanel(ProductManagementSystemFrame systemFrame, ProductGroup productGroup) {
        super(new GridLayout(1, 8));

        this.systemFrame = systemFrame;
        this.productGroup = productGroup;

        addColumns();
    }

    private void addColumns() {
        addNameLabel();
        addDescriptionLabel();
        addManufacturerLabel();
        addQuantityLabel();
        addPriceLabel();
        addEditButton();
        addDeleteButton();
        addAddProductButton();
    }

    private void addNameLabel() {
        JLabel label = new JLabel("Name");
        boldLabel(label);
        add(label);
    }

    private void addDescriptionLabel() {
        JLabel label = new JLabel("Description");
        boldLabel(label);
        add(label);
    }

    private void addManufacturerLabel() {
        JLabel label = new JLabel("Manufacturer");
        boldLabel(label);
        add(label);
    }

    private void addQuantityLabel() {
        JLabel label = new JLabel("Quantity");
        boldLabel(label);
        add(label);
    }

    private void addPriceLabel() {
        JLabel label = new JLabel("Price");
        boldLabel(label);
        add(label);
    }

    private void boldLabel(JLabel label) {
        label.setFont(label.getFont().deriveFont(label.getFont().getStyle() | Font.BOLD));
    }

    private void addEditButton() {
        JButton button = new JButton("Edit group");
        button.addActionListener(e -> ProductGroupService.editProductGroup(systemFrame, productGroup));
        add(button);
    }

    private void addDeleteButton() {
        JButton button = new JButton("Delete group");
        button.addActionListener(e -> ProductGroupService.removeProductGroup(systemFrame, productGroup));
        add(button);
    }

    private void addAddProductButton() {
        JButton button = new JButton("Add product");
        button.addActionListener(e -> ProductService.addProduct(systemFrame, productGroup));
        add(button);
    }
}
