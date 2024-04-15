package Models;

import Services.*;

import javax.swing.*;
import java.awt.event.*;

public class ProductManagementSystemFrame extends JFrame {
    private ProductManagementSystem system;

    public ProductManagementSystemFrame(ProductManagementSystem system) {
        super("Inventory Management System");

        this.system = system;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addProductGroupPanels();
        addSaveButton();
        addStatisticsButton();

        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addProductGroupPanels() {
        for (ProductGroup group : system.getProductGroups()) {
            String title = group.getGroupName() + " (" + group.getGroupDescription() + ")";
            JPanel productGroupPanel = new CollapsiblePanel(title, new ProductGroupPanel(group));
            add(productGroupPanel);
        }
    }

    private void addSaveButton() {
        JButton saveButton = new JButton("Save to file(s)");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileService.saveToFile(system);
            }
        });
        add(saveButton);
    }

    private void addStatisticsButton() {
        JButton statisticsButton = new JButton("Show statistics");
        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsService.displayStatistics(system);
            }
        });
        add(statisticsButton);
    }
}