package Models;

import javax.swing.*;
import java.awt.*;

public class ProductGroupPanel extends JPanel {
    private final ProductGroup productGroup;
    private ProductManagementSystemFrame systemFrame;

    public ProductGroupPanel(ProductGroup productGroup, ProductManagementSystemFrame systemFrame) {
        super(new GridLayout(0, 1));

        this.systemFrame = systemFrame;
        this.productGroup = productGroup;

        addProductPanels();
    }

    private void addProductPanels() {
        add(new ProductGroupTitleRowPanel(systemFrame, productGroup));
        for(Product product : productGroup.getProducts()) {
            add(new ProductPanel(systemFrame, productGroup, product));
        }
    }
}
