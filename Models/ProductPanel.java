package Models;

import Services.ProductService;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private final Product product;
    private final ProductGroup productGroup;
    private final ProductManagementSystemFrame systemFrame;

    public ProductPanel(ProductManagementSystemFrame systemFrame, ProductGroup productGroup, Product product) {
        super(new GridLayout(1, 8));

        this.product = product;
        this.productGroup = productGroup;
        this.systemFrame = systemFrame;

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
        add(new JLabel());
    }

    private void addNameLabel() {
        add(new JLabel(product.getProductName()));
    }

    private void addDescriptionLabel() {
        add(new JLabel(product.getDescription()));
    }

    private void addManufacturerLabel() {
        add(new JLabel(product.getManufacturer()));
    }

    private void addQuantityLabel() {
        add(new JLabel(String.valueOf(product.getQuantity())));
    }

    private void addPriceLabel() {
        add(new JLabel(String.valueOf(product.getPrice())));
    }

    private void addEditButton() {
        JButton button = new JButton("Edit");
        button.addActionListener(e -> ProductService.editProduct(systemFrame, product));
        add(button);
    }

    private void addDeleteButton() {
        JButton button = new JButton("Delete");
        button.addActionListener(e -> ProductService.removeProduct(systemFrame, productGroup, product));
        add(button);
    }
}
