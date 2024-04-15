package Models;

import javax.swing.*;
import java.awt.*;

public class ProductPanel extends JPanel {
    private final Product product;

    public ProductPanel(Product product) {
        super(new GridLayout(1, 8));
        this.product = product;
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
        JButton button = new JButton("Edit"); //TODO edit
        add(button);
    }

    private void addDeleteButton() {
        JButton button = new JButton("Delete"); //TODO delete
        add(button);
    }
}
