package Models;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CollapsiblePanel extends JPanel {
    private boolean isCollapsed = false;
    private JButton toggleButton;
    private JScrollPane scrollPane;

    public CollapsiblePanel(String title, JPanel contentPanel) {
        setLayout(new BorderLayout());

        toggleButton = new JButton(title + " ▼");
        toggleButton.setHorizontalAlignment(SwingConstants.LEFT);
        toggleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleContent();
            }
        });

        add(toggleButton, BorderLayout.NORTH);

        contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void toggleContent() {
        if (isCollapsed) {
            scrollPane.setVisible(true);
            toggleButton.setText(toggleButton.getText().replace("▲", "▼"));
        } else {
            scrollPane.setVisible(false);
            toggleButton.setText(toggleButton.getText().replace("▼", "▲"));
        }
        isCollapsed = !isCollapsed;
        revalidate();
        repaint();
    }
}