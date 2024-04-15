package Models;

import javax.swing.*;
import java.awt.*;

public class ProductGroupTitleRowPanel extends JPanel {
    public ProductGroupTitleRowPanel() {
        super(new GridLayout(1, 8));
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
        JButton button = new JButton("Edit category"); //TODO edit
        add(button);
    }

    private void addDeleteButton() {
        JButton button = new JButton("Delete category"); //TODO delete
        add(button);
    }

    private void addAddProductButton() {
        JButton button = new JButton("Add product"); //TODO add product
        add(button);
    }
}
