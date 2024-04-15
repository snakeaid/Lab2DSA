package Models;

import Models.*;

import java.util.*;

public class ProductManagementSystem {
    private List<ProductGroup> productGroups;

    public ProductManagementSystem() {
        this.productGroups = new ArrayList<>();
    }

    public List<ProductGroup> getProductGroups() {
        return productGroups;
    }

    public List<Product> getProducts() {
        return productGroups.stream().flatMap(group -> group.getProducts().stream()).toList();
    }

    public void addProductGroup(ProductGroup productGroup) {
        productGroups.add(productGroup);
    }

    public void removeProductGroup(ProductGroup productGroup) {
        productGroups.remove(productGroup);
    }

    public ProductGroup findProductGroup(ProductManagementSystem system, String groupName) {
        for (ProductGroup group : system.getProductGroups()) {
            if (group.getGroupName().equalsIgnoreCase(groupName)) {
                return group;
            }
        }
        return null;
    }
}
