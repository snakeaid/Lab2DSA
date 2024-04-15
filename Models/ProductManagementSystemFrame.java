package Models;

import Services.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ProductManagementSystemFrame extends JFrame {
    private ProductManagementSystem system;
    private JPanel productGroupsPanel;
    private List<JPanel> productGroupsPanels = new ArrayList<>();

    public ProductManagementSystemFrame(ProductManagementSystem system) {
        super("Inventory Management System");

        this.system = system;

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        addComponents();

        setSize(1200, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public ProductManagementSystem getSystem() {
        return system;
    }

    public void addComponents() {
        productGroupsPanel = new JPanel(new GridLayout(0, 1));
        add(new JScrollPane(productGroupsPanel));

        addProductGroupPanels();
        addButtonsPanel();
        pack();
    }

    public void render() {
        addProductGroupPanels();
        pack();
    }

    private void addProductGroupPanels() {
        for(JPanel panel : productGroupsPanels) {
            productGroupsPanel.remove(panel);
        }
        productGroupsPanels.clear();

        pack();

        for (ProductGroup group : system.getProductGroups()) {
            String title = group.getGroupName() + " (" + group.getGroupDescription() + ")";
            CollapsiblePanel productGroupPanel = new CollapsiblePanel(title, new ProductGroupPanel(group, this));
            productGroupsPanels.add(productGroupPanel);
            productGroupsPanel.add(productGroupPanel);
        }
        pack();
    }

    private void addButtonsPanel() {
        JPanel buttonsPanel = new JPanel(new FlowLayout());
        addAddCategoryButton(buttonsPanel);
        addSaveButton(buttonsPanel);
        addStatisticsButton(buttonsPanel, this);
        add(buttonsPanel);
    }

    private void addAddCategoryButton(JPanel panel) {
        JButton addCategoryButton = new JButton("Add group");
        addCategoryButton.addActionListener(e -> ProductGroupService.addProductGroup(this));
        panel.add(addCategoryButton);
    }

    private void addSaveButton(JPanel panel) {
        JButton saveButton = new JButton("Save to file(s)");
        saveButton.addActionListener(e -> FileService.saveToFile(system));
        panel.add(saveButton);
    }

    private void addStatisticsButton(JPanel panel, ProductManagementSystemFrame systemFrame) {
        JButton statisticsButton = new JButton("Show statistics");
        statisticsButton.addActionListener(e -> StatisticsService.displayStatistics(systemFrame));
        panel.add(statisticsButton);
    }
}