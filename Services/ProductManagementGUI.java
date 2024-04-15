package Services;

import Models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProductManagementGUI {
    private ProductManagementSystem system;
    private JFrame frame;
    private JPanel backgroundPanel;

    public ProductManagementGUI(ProductManagementSystem system, JFrame frame) {
        this.system = system;
        this.frame = frame;
    }

    public void createAndAddButtons() {
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(backgroundPanel);
        JButton saveButton = new JButton("Save Data to File");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileService.saveToFile(system);
            }
        });
        frame.add(saveButton);

        JButton productButton = new JButton("Product");
        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductService.showProductOptions(system);
            }
        });
        frame.add(productButton);

        JButton productGroupButton = new JButton("Product Group");
        productGroupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductGroupService.showProductGroupOptions(system);
            }
        });
        frame.add(productGroupButton);

        JButton searchButton = new JButton("Search Product");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductService.searchProduct(system);
            }
        });
        frame.add(searchButton);

        JButton statisticsButton = new JButton("Display Statistics");
        statisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsService.displayStatistics(system);
            }
        });
        frame.add(statisticsButton);

        JButton backgroundButton = new JButton("Change Background");
        backgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackground();
            }
        });
        frame.add(backgroundButton);

        JTextArea logArea = new JTextArea(10, 30);
        logArea.setEditable(false);
        frame.add(new JScrollPane(logArea));
    }

    private ImageIcon backgroundImage;

    private void changeBackground() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                backgroundImage = new ImageIcon(selectedFile.getAbsolutePath());
                backgroundPanel.repaint();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error loading background image.");
                ex.printStackTrace();
            }
        }
    }
}