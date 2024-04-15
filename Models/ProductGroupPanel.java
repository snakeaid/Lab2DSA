package Models;

import javax.swing.*;
import java.awt.*;

public class ProductGroupPanel extends JPanel {
    private final ProductGroup productGroup;

    public ProductGroupPanel(ProductGroup productGroup) {
        super(new GridLayout(0, 1));
        this.productGroup = productGroup;

        addProductPanels();
    }

    private void addProductPanels() {
        add(new ProductGroupTitleRowPanel());
        for(Product product : productGroup.getProducts()) {
            add(new ProductPanel(product));
        }
    }
}
