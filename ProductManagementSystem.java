import java.util.List;
import java.util.ArrayList;

class ProductManagementSystem {
    private List<ProductGroup> productGroups;

    public ProductManagementSystem() {
        this.productGroups = new ArrayList<>();
    }

    public List<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public void addProductGroup(ProductGroup productGroup) {
        productGroups.add(productGroup);
    }

    public void removeProductGroup(ProductGroup productGroup) {
        productGroups.remove(productGroup);
    }

    public void removeAllProductsInGroup(ProductGroup productGroup) {
        productGroups.remove(productGroup);
        productGroup.getProducts().clear();
    }
}
